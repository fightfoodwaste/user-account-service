package com.fightfoodwaste.useraccountservice.service;

import com.fightfoodwaste.useraccountservice.dto.GetAccountResponse;
import com.fightfoodwaste.useraccountservice.entity.AccountEntity;
import com.fightfoodwaste.useraccountservice.exceptions.AccountNotFoundException;
import com.fightfoodwaste.useraccountservice.message.SafeDeletionPayload;
import com.fightfoodwaste.useraccountservice.message.UserRegisteredPayload;
import com.fightfoodwaste.useraccountservice.repository.AccountRepository;
import com.fightfoodwaste.useraccountservice.utility.ObjConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService{

    private final AccountRepository repository;
    private final ObjConverter objConverter;
    @Override
    public GetAccountResponse getAccount(long id) throws AccountNotFoundException {

        AccountEntity accountEntity = repository.findById(id).orElseThrow(AccountNotFoundException::new);
        GetAccountResponse response = objConverter.accountEntityToDTO(accountEntity);
        return response;

    }

    public void saveAccount(UserRegisteredPayload payload){
        AccountEntity accountEntity = objConverter.userRegisteredPayloadToEntity(payload);
        repository.save(accountEntity);
    }

    @Override
    public void deleteAccount(SafeDeletionPayload payload) {
        repository.deleteById(payload.getId());
        System.out.println("Successful deletion of account with id: " + payload.getId());
    }


}
