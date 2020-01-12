package com.example.game_set_match;

import android.nfc.Tag;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static android.content.ContentValues.TAG;

public class Game {
    private int GameId;
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

        this.GameId = 1; // generate game ID
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

        FirebaseFirestore Start = FirebaseFirestore.getInstance();
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("StartTime", Calendar.getInstance().getTime());
        parameters.put("GameId", GameId);
        parameters.put("Player1", player1.username);
        parameters.put("Player2", player2.username);
        parameters.put("Game Over", GameOver);

        Start.collection("Active_Games").document(Integer.toString(GameId)).set(parameters)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG, "DocumentSnapshot successfully written!");
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.w(TAG, "Error writing document", e);
            }
        });

    }

    public void EndGame(int gid) {
        final Map<String, Object> params = new HashMap<>();

        params.put("GameOver",true);
        params.put("EndTime",Calendar.getInstance().getTime());
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        db.collection("Active_Games")
                .document(Integer.toString(gid))
                .set(params, SetOptions.merge())
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        //GameObject.GameOver = params.get("GameOver");
                        //this.EndTime = params.get("EndTime");
                        // go to winner screen
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception ex) {
                        Log.e(TAG,ex.getMessage());
                    }
                });

    }

    public void SetWinner(int gameId,String winner) {
        // TODO
        // winner = winner's username
        // game = game id
        // algorithm:
        //  1. get game from firestore
        //  2. get winning player based on winner username,
    }
}
