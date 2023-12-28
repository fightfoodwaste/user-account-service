package com.fightfoodwaste.useraccountservice.service;

import com.fightfoodwaste.useraccountservice.dto.GetAccountResponse;
import com.fightfoodwaste.useraccountservice.exceptions.AccountNotFoundException;

public interface AccountService {

    GetAccountResponse getAccount(int id) throws AccountNotFoundException;

}
