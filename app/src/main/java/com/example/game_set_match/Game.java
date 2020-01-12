package com.example.game_set_match;

import java.time.*;
import java.time.LocalDateTime;

public class Game {
    private int gameId;
    private LocalDateTime StartTime;
    private LocalDateTime endTime;
    private newUser player1;
    private newUser player2;
    private newUser winner;
    private boolean GameOver;

    public Game() {
        // empty constructor
    }

    public void StartGame(newUser player1, newUser player2) {
        this.gameId = 1; // generate game ID
        this.StartTime = LocalDateTime.now();
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
}
