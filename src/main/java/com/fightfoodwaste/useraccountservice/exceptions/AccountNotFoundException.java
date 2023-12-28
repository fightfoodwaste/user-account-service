package com.fightfoodwaste.useraccountservice.exceptions;



public class AccountNotFoundException extends Exception{
    public AccountNotFoundException(){
        super("Acccount with such ID does not exist");
    }
}
