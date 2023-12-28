package com.fightfoodwaste.useraccountservice.service;

import com.fightfoodwaste.useraccountservice.message.UserRegisteredPayload;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ConsumingServiceImpl implements ConsumingService{

    private final AccountService accountService;

    @Override
    @RabbitListener(queues = "user-registration")
    public void onUserRegistration(UserRegisteredPayload payload) {
        System.out.println(payload.getAuth_id());
        accountService.saveAccount(payload);
    }
}
