package com.fightfoodwaste.useraccountservice.service;

import com.fightfoodwaste.useraccountservice.env.EnvVariables;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

@Service
@RequiredArgsConstructor
public class EncryptionServiceImpl implements EncryptionService{

    private final EnvVariables envVariables;

    @Override
    public String decrypt(String data) throws Exception{
        byte[] decodedKey = getDecodedKey();
        String algorithm = envVariables.getEncryptionAlgorithm();

        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(decodedKey, algorithm));
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(data));
        return new String(decryptedBytes);
    }

    private byte[] getDecodedKey(){
        return Base64.getDecoder().decode(this.envVariables.getEncryptionKey());
    }
}
