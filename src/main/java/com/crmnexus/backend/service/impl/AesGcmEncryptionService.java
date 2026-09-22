package com.crmnexus.backend.service.impl;

import com.crmnexus.backend.service.interfaces.EncryptService;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;

@Service
public class AesGcmEncryptionService implements EncryptService {
    private final static String ALGORITHM = "AES/GCM/NoPadding";
    private final static int IV_LENGTH = 12;
    private final static int TAG_LENGTH = 128;

    private final SecretKey secretKey;
    private final SecureRandom secureRandom = new SecureRandom();


    public AesGcmEncryptionService(SecretKey secretKey) {
        this.secretKey = secretKey;
    }


    @Override
    public String encrypt(String plainText) {
        byte[] iv = new byte[IV_LENGTH];
        secureRandom.nextBytes(iv);

        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            GCMParameterSpec parameterSpec = new GCMParameterSpec(TAG_LENGTH, iv);

            cipher.init(
                    Cipher.ENCRYPT_MODE,
                    secretKey,
                    parameterSpec
            );


            byte[] encrypted = cipher.doFinal(
                    plainText.getBytes(StandardCharsets.UTF_8)
            );


            ByteBuffer byteBuffer = ByteBuffer.allocate(
                    iv.length + encrypted.length
            );

            byteBuffer.put(iv);
            byteBuffer.put(encrypted);


            return Base64.getEncoder().
                    encodeToString(byteBuffer.array());

        } catch (GeneralSecurityException e) {
            throw new IllegalStateException("Could not encrypt value", e);
        }
    }

    @Override
    public String decrypt(String encryptedText) {
         try {

             byte[] combinedData = Base64.getDecoder()
                     .decode(encryptedText);


             if (combinedData.length < IV_LENGTH + TAG_LENGTH / 8) {

                 throw new IllegalStateException("Encrypted value is too short");
             }

            byte[] iv = Arrays.copyOfRange(
                 combinedData,
                 0,
                 IV_LENGTH
            );


             byte[] cipherText = Arrays.copyOfRange(
                     combinedData,
                     IV_LENGTH,
                     combinedData.length
             );



             Cipher cipher = Cipher.getInstance(ALGORITHM);


             GCMParameterSpec parameterSpec =
                     new GCMParameterSpec(TAG_LENGTH, iv);


             cipher.init(
                     Cipher.DECRYPT_MODE,
                     secretKey,
                     parameterSpec
             );



             byte[] plainTextBytes = cipher.doFinal(cipherText);


             return new String(plainTextBytes, StandardCharsets.UTF_8);



         }
         catch (GeneralSecurityException | IllegalArgumentException exception) {
             throw new IllegalStateException("Could not decrypt value", exception);
         }


    }
}
