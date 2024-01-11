package com.fightfoodwaste.useraccountservice.utility;

import com.fightfoodwaste.useraccountservice.dto.GetAccountResponse;
import com.fightfoodwaste.useraccountservice.entity.AccountEntity;
import com.fightfoodwaste.useraccountservice.message.UserRegisteredPayload;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ObjConverter {

    public GetAccountResponse accountEntityToDTO(AccountEntity entity){
        return new GetAccountResponse(
                entity.getId(),
                entity.getFirst_name(),
                entity.getLast_name(),
                new Date(entity.getDate_of_birth())
        );
    }

    public AccountEntity userRegisteredPayloadToEntity(UserRegisteredPayload payload){
        return new AccountEntity(
                payload.getAuth_id(),
                payload.getFirst_name(),
                payload.getLast_name(),
                payload.getDate_of_birth());
    }
}
