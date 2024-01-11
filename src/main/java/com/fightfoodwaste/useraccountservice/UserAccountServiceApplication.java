package com.fightfoodwaste.useraccountservice;

import com.fightfoodwaste.useraccountservice.service.ConsumingService;
import com.fightfoodwaste.useraccountservice.service.ConsumingServiceImpl;
import com.fightfoodwaste.useraccountservice.utility.ObjConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class UserAccountServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(UserAccountServiceApplication.class, args);

    }
}
