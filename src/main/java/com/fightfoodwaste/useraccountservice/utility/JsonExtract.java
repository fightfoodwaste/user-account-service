package com.fightfoodwaste.useraccountservice.utility;


import com.fightfoodwaste.useraccountservice.message.UserRegisteredPayload;

public interface JsonExtract {
    UserRegisteredPayload convertUserRegisterJsonToPayload(String json);

}
