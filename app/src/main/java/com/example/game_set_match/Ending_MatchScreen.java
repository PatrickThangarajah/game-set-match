package com.example.game_set_match;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Ending_MatchScreen extends AppCompatActivity {
    private Button exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ending__match_screen);
        this.exit = (Button) findViewById(R.id.endButton1);
        exit.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                goToQR();
            }
        });
    }

        public void goToQR () {
        Intent intent = new Intent(getApplicationContext(), QR.class);
        startActivity(intent);
    }
}