package com.example.demo.hash;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class md5 {
    public md5() {

    }
    public String passwd(String text) {
        try {
            // Création d'une instance de MessageDigest avec l'algorithme MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // Mise à jour du hachage avec la chaîne de caractères
            md.update(text.getBytes());

            // Récupération du hachage en bytes
            byte[] hashedBytes = md.digest();

            // Conversion des bytes en format hexadécimal
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            System.err.println("MD5 algorithm not found.");
        }
        return null;
    }
}
