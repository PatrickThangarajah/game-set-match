package com.example.game_set_match;

import android.nfc.Tag;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static android.content.ContentValues.TAG;

public class Game {
    private String GameId;
    private Date StartTime;
    private Date endTime;
    private User player1;
    private User player2;
    private User loser;
    private User winner;
    private boolean GameOver;
    FirebaseFirestore Start = FirebaseFirestore.getInstance();

    public Game() {
        // empty constructor
    }

    public void StartGame(User player1, User player2) {
        Random r = new Random();
        this.GameId = Integer.toString(r.nextInt(100) + 1);
        this.StartTime = Calendar.getInstance().getTime();
        this.player1 = player1;
        this.player2 = player2;
        //this.winner = new User();
        this.GameOver = false;



        // figure out how to store this into a new document on firebase;
        // this.gameId = -1;
        // this.StartTime = ;
        // this.player1.username = "a";
        // this.player2.username = "b";
        // this.GameOver = false;

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("StartTime", Calendar.getInstance().getTime());
        parameters.put("GameId", GameId);
        //parameters.put("Player1", player1.username);
        //parameters.put("Player2", player2.username);
        parameters.put("Game Over", GameOver);

        Start.collection("Active_Games").document(GameId).set(parameters)
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
        SetWinner(GameId);

    }

    public String SetWinner(String gameId) {
        String winner_username;
        boolean won = true;
        if (won) {
            winner = getUser1();
            winner_username = winner.getUsername();
        } else {
            winner = getUser2();
            winner_username = winner.getUsername();
        }
        updateDatabase();
        return winner_username;
    }

    public void updateDatabase(){
        winner.addPoints(15);
        loser.subtractPoints(10);
    }

    public User getUser1(){return player1;}
    public User getUser2(){return player2;}

}
