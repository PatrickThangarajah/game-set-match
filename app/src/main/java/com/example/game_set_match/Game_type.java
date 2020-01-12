package com.example.game_set_match;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game_type {

    private String name;
    private ArrayList<User> listOfUsers;

    public Game_type(String name, FirebaseFirestore db){
        this.name = name;
        db.collection("GameType").add(this);
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