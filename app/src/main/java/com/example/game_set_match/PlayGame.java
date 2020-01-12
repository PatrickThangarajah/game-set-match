package com.example.game_set_match;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

public class PlayGame extends AppCompatActivity {

    private Chronometer chronometer;

    //  @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);

        chronometer = findViewById(R.id.cmTimer);
        chronometer.setFormat("Length of Game: %s");
        chronometer.setBase(SystemClock.elapsedRealtime());
        //chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {

        chronometer.start();

    }


}
