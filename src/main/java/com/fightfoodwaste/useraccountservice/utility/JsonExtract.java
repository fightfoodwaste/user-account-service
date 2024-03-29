package com.fightfoodwaste.useraccountservice.utility;


import com.fightfoodwaste.useraccountservice.message.SafeDeletionPayload;
import com.fightfoodwaste.useraccountservice.message.UserRegisteredPayload;

import javax.crypto.SecretKey;

public interface JsonExtract {
    UserRegisteredPayload convertUserRegisterJsonToPayload(String json);

    SafeDeletionPayload convertSafeDeletionJsonToPayload(String json);

    SecretKey getSignKey();

    String getSubjectFromToken(String token);

}
