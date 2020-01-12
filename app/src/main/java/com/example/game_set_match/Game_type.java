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

    private String name;
    private ArrayList<User> listOfUsers;

    public Game_type(String name, String doc, FirebaseFirestore db){
        this.name = name;
        listOfUsers = new ArrayList<User>();
        db.collection("GameType").document(doc).set(this);
    }


    public void addUser(User u){
        listOfUsers.add(u);
    }

    public void deleteUser(User u){
        listOfUsers.remove(u);
    }

    public String getName(){return name;}
    public ArrayList<User> getListOfUsers(){return listOfUsers;}
}