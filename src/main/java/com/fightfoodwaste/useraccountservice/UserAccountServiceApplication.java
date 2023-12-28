package com.fightfoodwaste.useraccountservice;

import com.fightfoodwaste.useraccountservice.utility.ObjConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UserAccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserAccountServiceApplication.class, args);
    }

    @Bean
    public ObjConverter objConverter(){
        return new ObjConverter();
    }

}
