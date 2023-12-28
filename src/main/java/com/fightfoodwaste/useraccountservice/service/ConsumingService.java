package com.fightfoodwaste.useraccountservice.service;

import com.fightfoodwaste.useraccountservice.message.UserRegisteredPayload;

public interface ConsumingService {

    void onUserRegistration(UserRegisteredPayload payload);
}
