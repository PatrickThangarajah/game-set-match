package com.example.game_set_match;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Game {
    private int gameId;
    private Date StartTime;
    private Date endTime;
    private newUser player1;
    private newUser player2;
    private newUser winner;
    private boolean GameOver;

    public Game() {
        // empty constructor
    }

    public void StartGame(newUser player1, newUser player2) {
        this.gameId = 1; // generate game ID
        this.StartTime = Calendar.getInstance().getTime();
        this.player1 = player1;
        this.player2 = player2;
        this.winner = new newUser();
        this.GameOver = false;

        // figure out how to store this into a new document on firebase;
        // this.gameId;
        // this.StartTime;
        // this.player1.username;
        // this.player2.username;
        // this.GameOver;

    }

    public void EndGame(int gid) {
        Map<String, Object> params = new HashMap<>();

        params.put("GameOver",true);
        params.put("EndTime",Calendar.getInstance().getTime());

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        //db.collection("Active Games")

    }

    public void SetWinner(int gameId,String winner) {

    }
}
