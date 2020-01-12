package com.example.game_set_match;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private Button signin;
private Button signup;

FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialize();

        setContentView(R.layout.signinfrontend);
        signin =(Button) findViewById(R.id.sign_in);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openactivity_sign_in();
            }
        });
        signup=(Button) findViewById(R.id.sign_up);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openactivity_sign_up();
            }
        });
        setContentView(R.layout.signinfrontend);
    }

    public void initialize(){
        //new Game_type("Chess", db);
        //new Game_type("Ping Pong",db);
    }
    public void openactivity_sign_up() {
        Intent intent = new Intent(this,SignUpActivity.class);
        startActivity(intent);}
    public void openactivity_sign_in() {
        Intent intent = new Intent(this,sign_in.class);
        startActivity(intent);}
}


/*
rules_version = '2';
        service cloud.firestore {
        match /databases/{database}/documents {
        match /{document=**} {
        allow read, write: if false;
        }
        }
        }*/

