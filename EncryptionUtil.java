package com.PassWordManagement;

public class EncryptionUtil {

    public static String encrypt(String text) {

        StringBuilder encrypted = new StringBuilder();

        for(char c : text.toCharArray()){
            encrypted.append((char)(c + 3));
        }

        return encrypted.toString();
    }

    public static String decrypt(String text) {

        StringBuilder decrypted = new StringBuilder();

        for(char c : text.toCharArray()){
            decrypted.append((char)(c - 3));
        }

        return decrypted.toString();
    }
}