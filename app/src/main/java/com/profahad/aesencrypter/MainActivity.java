package com.profahad.aesencrypter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private final String key = "MjZrb3pRYUt3UnVOSjI0dDI2a296UWFLd1J1TkoyNHQ=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String card = "Here is Fahad";
        String encryptedB = AES.getInstance(key).encrypt(card);
        String decryptedB = AES.getInstance(key).decrypt(encryptedB);
        Log.d("DATA: DECRYPTED", "onCreate: " + decryptedB);
        Log.d("DATA: ENCRYPTED", "onCreate: " + encryptedB);
    }

}