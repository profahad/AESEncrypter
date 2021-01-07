package com.profahad.aesencrypter;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AES {

    private static AES instance;

    public static AES getInstance(String key) {
        if (instance == null)
            instance = new AES(key);
        return instance;
    }

    private String key;

    private AES(String key) {
        this.key = new String(android.util.Base64.decode(key, android.util.Base64.DEFAULT));
    }

    public String encrypt(String input) {
        byte[] crypted = null;
        try {

            SecretKeySpec skey = new SecretKeySpec(key.getBytes(), "AES");

            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, skey);
            crypted = cipher.doFinal(input.getBytes());
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        // Base64Decoder for Android O and above api level
        // java.util.Base64.Encoder encoder = java.util.Base64.getEncoder();
        // return new String(encoder.encodeToString(crypted));

        return new String(android.util.Base64.encode(crypted, android.util.Base64.DEFAULT));
    }

    public String decrypt(String input) {
        byte[] output = null;
        try {

            // Base64Decoder for Android O and above api level
            // java.util.Base64.Decoder decoder = java.util.Base64.getDecoder();
            // output = cipher.doFinal(decoder.decode(input));

            SecretKeySpec skey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, skey);


            output = cipher.doFinal(android.util.Base64.decode(input, android.util.Base64.DEFAULT));

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return new String(output != null ? output : new byte[]{});
    }
}
