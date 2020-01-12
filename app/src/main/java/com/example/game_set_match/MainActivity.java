package com.example.game_set_match;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
private Button signin;
private Button signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

    }
    public void openactivity_sign_up() {
        Intent intent = new Intent(this,SignUpActivity.class);
        startActivity(intent);}
    public void openactivity_sign_in() {
        Intent intent = new Intent(this,sign_in.class);
        startActivity(intent);}
                                  }



