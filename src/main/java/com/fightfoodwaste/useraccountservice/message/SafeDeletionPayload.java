package com.fightfoodwaste.useraccountservice.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SafeDeletionPayload {

    private long id;
}
