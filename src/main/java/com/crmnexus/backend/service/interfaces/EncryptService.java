package com.crmnexus.backend.service.interfaces;

public interface EncryptService {

    String encrypt(String plainText);
    String decrypt(String cipherText);
}
