package com.fightfoodwaste.useraccountservice.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisteredPayload {

    private int auth_id;
    private String first_name;
    private String last_name;
    private Date date_of_birth;
}
