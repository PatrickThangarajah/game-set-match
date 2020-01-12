package com.example.game_set_match;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class SignUpActivity extends AppCompatActivity {
    private Button back;
    private Button enter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signinfrontend);
        back =(Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openback();
            }
        });
        enter=(Button) findViewById(R.id.sign_up);
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openenter();
            }
        });

    }
    public void openback() {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);}
    public void openenter() {
        Intent intent = new Intent(this,sign_in.class);
        startActivity(intent);}
}
