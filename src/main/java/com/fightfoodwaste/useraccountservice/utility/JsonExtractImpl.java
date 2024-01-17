package com.fightfoodwaste.useraccountservice.utility;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fightfoodwaste.useraccountservice.env.EnvVariables;
import com.fightfoodwaste.useraccountservice.message.UserRegisteredPayload;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Base64;

@Component
@RequiredArgsConstructor
public class JsonExtractImpl implements JsonExtract{

    private final ObjectMapper mapper;

    private final EnvVariables envVariables;

    public UserRegisteredPayload convertUserRegisterJsonToPayload(String json) {
        try{
            UserRegisteredPayload payload = mapper.readValue(json, UserRegisteredPayload.class);
            return payload;
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public SecretKey getSignKey() {
        // Replace with your key retrieval logic
        String secretKey = envVariables.getKey(); // Ensure this is the same key used to sign the JWT
        byte[] keyBytes = Base64.getDecoder().decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String getSubjectFromToken(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(getSignKey())
                .build()
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }
}
