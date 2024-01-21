package com.fightfoodwaste.useraccountservice.service;

import com.fightfoodwaste.useraccountservice.config.MessagingConfig;
import com.fightfoodwaste.useraccountservice.message.SafeDeletionPayload;
import com.fightfoodwaste.useraccountservice.message.UserRegisteredPayload;
import com.fightfoodwaste.useraccountservice.utility.JsonExtract;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ConsumingServiceImpl implements ConsumingService{

    private final AccountService accountService;

    private final EncryptionService encryptionService;

    private final JsonExtract jsonExtract;

    @RabbitListener(queues = MessagingConfig.USER_REGISTRATION_QUEUE_NAME)
    public void onUserRegistrationListener(String encryptedPayload){
        try{
            String decryptedPayload = encryptionService.decrypt(encryptedPayload);
            UserRegisteredPayload payload = jsonExtract.convertUserRegisterJsonToPayload(decryptedPayload);
            accountService.saveAccount(payload);
            System.out.println("Saved account: " + payload.toString());

        }catch (Exception e){
            System.out.println("Error decoding message");
        }
    }

    @RabbitListener(queues = MessagingConfig.SAFE_DELETION_QUEUE_NAME)
    public void onSafeDeletionListener(String encryptedPayload){
        try{
            String decryptedPayload = encryptionService.decrypt(encryptedPayload);
            SafeDeletionPayload payload = jsonExtract.convertSafeDeletionJsonToPayload(decryptedPayload);
            accountService.deleteAccount(payload);
        }catch(Exception e){
            System.out.println("Error decoding message");
        }
    }

    /*@Override
    public void onUserRegistrationListener() {
        String queue_name = "user-registration";
        try{
            channel.queueDeclare(queue_name, true, false, false, null);
            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String message = new String(delivery.getBody(), "UTF-8");
                UserRegisteredPayload payload = jsonExtract.convertUserRegisterJsonToPayload(message);
                accountService.saveAccount(payload);

            };
            channel.basicConsume(queue_name, true, deliverCallback , consumerTag -> {});
        } catch(IOException e){
            e.printStackTrace();
            System.out.println("Connection error");
        }
    }*/

}
