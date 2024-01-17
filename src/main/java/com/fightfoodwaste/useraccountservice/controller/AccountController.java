package com.fightfoodwaste.useraccountservice.controller;

import com.fightfoodwaste.useraccountservice.dto.GetAccountResponse;
import com.fightfoodwaste.useraccountservice.exceptions.AccountNotFoundException;
import com.fightfoodwaste.useraccountservice.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping
    public String test(){
        return "works";
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetAccountResponse> getAccountById(@PathVariable("id") long id){
        try{
            GetAccountResponse response = accountService.getAccount(id);
            return ResponseEntity.ok().body(response);
        }
        catch(AccountNotFoundException e){
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
        catch(RuntimeException e){
            return ResponseEntity.internalServerError().build();
        }
    }
}
