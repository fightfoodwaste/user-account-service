package com.fightfoodwaste.useraccountservice.service;

import com.fightfoodwaste.useraccountservice.dto.GetAccountResponse;
import com.fightfoodwaste.useraccountservice.entity.Account;
import com.fightfoodwaste.useraccountservice.exceptions.AccountNotFoundException;
import com.fightfoodwaste.useraccountservice.message.UserRegisteredPayload;
import com.fightfoodwaste.useraccountservice.repository.AccountRepository;
import com.fightfoodwaste.useraccountservice.utility.ObjConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService{

    private final AccountRepository repository;
    private final ObjConverter objConverter;
    @Override
    public GetAccountResponse getAccount(int id) throws AccountNotFoundException {

        Account account = repository.findById(id).orElseThrow(AccountNotFoundException::new);
        GetAccountResponse response = objConverter.accountEntityToDTO(account);
        return response;

    }

    public void saveAccount(UserRegisteredPayload payload){
        Account account = objConverter.userRegisteredPayloadToEntity(payload);
        repository.save(account);
    }


}
