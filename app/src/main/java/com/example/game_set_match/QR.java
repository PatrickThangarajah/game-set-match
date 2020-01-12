package com.example.game_set_match;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.HashMap;
import java.util.Map;

public class QR extends AppCompatActivity {

    private String GetQrApiUrl(String username) {
        return GetQrApiUrl(username,500,500);
    }

    private String GetQrApiUrl(String username, int width, int length) {
        Map<String,String> params = new HashMap<>();
        char andSymbol = '&';

        params.put("baseUrl","https://chart.googleapis.com/chart?");
        params.put("chartType","cht=qr");
        params.put("dimensions",String.format("chs=%dx%d",width,length));
        params.put("data",String.format("chl=%s",username));

        return params.get("baseUrl") +
                andSymbol +
                params.get("chartType") +
                andSymbol +
                params.get("dimensions") +
                andSymbol +
                params.get("data");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr);

        newUser user = new newUser(); // get logged in user;
        user.username = "test"; // placeholder



    }
}
