package com.fightfoodwaste.useraccountservice.message;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisteredPayload {

    private Long auth_id;
    private String first_name;
    private String last_name;
    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    private Long date_of_birth;
}
