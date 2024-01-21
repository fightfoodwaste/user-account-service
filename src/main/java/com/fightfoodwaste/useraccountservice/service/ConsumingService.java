package com.fightfoodwaste.useraccountservice.service;

import com.fightfoodwaste.useraccountservice.message.UserRegisteredPayload;

public interface ConsumingService {

    void onUserRegistrationListener(String encryptedPayload);
    void onSafeDeletionListener(String encryptedPayload);
}
