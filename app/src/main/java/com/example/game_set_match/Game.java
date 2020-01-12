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


    public void StartGame(final String username1, final String username2){

        final FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("Users").document(username1).get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(final DocumentSnapshot documentSnapshot1) {
                        db.collection("Users").document(username2).get()
                                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                                    @Override
                                    public void onSuccess(DocumentSnapshot documentSnapshot2) {
                                        StartGame(docToUser(documentSnapshot1),docToUser(documentSnapshot2));
                                    }
                                });
                    }
                });
    }

    public void StartGame(User player1, User player2) {
        Random r = new Random();
        this.GameId = Integer.toString(r.nextInt(100) + 1);
        this.StartTime = Calendar.getInstance().getTime();
        this.player1 = player1;
        this.player2 = player2;
        //this.winner = new User();
        this.GameOver = false;


        Map<String, Object> parameters = new HashMap<>();
        parameters.put("StartTime", Calendar.getInstance().getTime());
        parameters.put("GameId", GameId);
        parameters.put("Player1", player1.getUsername());
        parameters.put("Player2", player2.getUsername());
        parameters.put("Game Over", GameOver);

        Start.collection("SeekingPlayers").document(player1.getUsername()).delete();
        Start.collection("SeekingPlayers").document(player2.getUsername()).delete();

        Start.collection("Active_Games").document(GameId).set(parameters);

    }

    public void EndGame(String username) {
        final Map<String, Object> params = new HashMap<>();

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("Active_Games").whereEqualTo("Player1",username).get();
        db.collection("Active_Games").whereEqualTo("Player2",username);
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


    private User docToUser(DocumentSnapshot d) {
        return new User(
                d.get("fname").toString(),
                d.get("lname").toString(),
                d.get("username").toString(),
                d.get("email").toString(),
                d.get("pw").toString());
    }
}
