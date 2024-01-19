package com.fightfoodwaste.useraccountservice.service;

import com.fightfoodwaste.useraccountservice.config.MessagingConfig;
import com.fightfoodwaste.useraccountservice.message.UserRegisteredPayload;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ConsumingServiceImpl implements ConsumingService{

    private final AccountService accountService;

    //private final JsonExtract jsonExtract;

    @RabbitListener(queues = MessagingConfig.QUEUE_NAME)
    public void onUserRegistrationListener(UserRegisteredPayload payload){
        System.out.println(payload);
        accountService.saveAccount(payload);
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
