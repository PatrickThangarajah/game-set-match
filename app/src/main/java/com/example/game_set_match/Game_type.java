package com.example.game_set_match;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.content.ContentValues.TAG;

public class Game_type {
    private List<User> listOfUsers;

    public Game_type(String doc, FirebaseFirestore db){
        //if (db.collection("GameType").document(doc).get())
        listOfUsers = (List<User>) db.collection("GameType").document(doc).get();
        db.collection("GameType").document(doc).set(this);
    }


    public void addUser(User u){
        listOfUsers.add(u);
    }

    public void deleteUser(User u){
        listOfUsers.remove(u);
    }

    public List<User> getListOfUsers(){return listOfUsers;}
}