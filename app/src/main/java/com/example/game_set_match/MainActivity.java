package com.example.game_set_match;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    FirebaseFirestore GameType = FirebaseFirestore.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialize();
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this,QR.class);
        startActivity(intent);

    }

    public void initialize(){
        new Game_type("Chess", GameType);
        new Game_type("Ping Pong", GameType);
    }
}
