package com.fightfoodwaste.useraccountservice.utility;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fightfoodwaste.useraccountservice.message.UserRegisteredPayload;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JsonExtractImpl implements JsonExtract{

    private final ObjectMapper mapper;

    public UserRegisteredPayload convertUserRegisterJsonToPayload(String json) {
        try{
            UserRegisteredPayload payload = mapper.readValue(json, UserRegisteredPayload.class);
            return payload;
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
