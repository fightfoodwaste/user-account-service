package com.fightfoodwaste.useraccountservice.utility;

import com.fightfoodwaste.useraccountservice.dto.GetAccountResponse;
import com.fightfoodwaste.useraccountservice.entity.Account;
import org.springframework.stereotype.Component;

import java.util.Date;

public class ObjConverter {

    public GetAccountResponse accountEntityToDTO(Account entity){
        return new GetAccountResponse(
                entity.getId(),
                entity.getFirst_name(),
                entity.getLast_name(),
                entity.getDate_of_birth()
        );
    }
}
