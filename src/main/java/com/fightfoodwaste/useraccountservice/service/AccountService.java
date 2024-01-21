package com.fightfoodwaste.useraccountservice.service;

import com.fightfoodwaste.useraccountservice.dto.GetAccountResponse;
import com.fightfoodwaste.useraccountservice.exceptions.AccountNotFoundException;
import com.fightfoodwaste.useraccountservice.message.SafeDeletionPayload;
import com.fightfoodwaste.useraccountservice.message.UserRegisteredPayload;

public interface AccountService {

    GetAccountResponse getAccount(long id) throws AccountNotFoundException;

    void saveAccount(UserRegisteredPayload payload);

    void deleteAccount(SafeDeletionPayload payload);
}
