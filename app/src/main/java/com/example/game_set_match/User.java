package com.example.game_set_match;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class User {
    private String fname;
    private String lname;
    private String username;
    private String email;
    private String password;
    private int points;
    private ArrayList<Game_type> games;

    public User(String fname, String lname, String username, String email, String pw, FirebaseFirestore db){
        this.fname = fname;
        this.lname = lname;
        this.username = username;
        this.email = email;
        this.password = pw;
        points = 0;
        db.collection("Users").add(this);
        games = new ArrayList<Game_type>();
    }

    public void addGame(Game_type g){
        games.add(g);
        g.addUser(this);
    }

    public void removeGame(Game_type g){
        games.remove(g);
        g.deleteUser(this);
    }

    public void addPoints(int p){
        points+=p;
    }

    public void subtractPoints(int p){
        points-=p;
    }

    public void setFirstname(String name){
        this.fname = name;
    }

    public void setLastname(String name){
        this.lname = name;
    }

    public void setUsername(String name){
        this.username = name;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setPassword(String password){
        this.email = email;
    }

    public String getPassword() {return password;}
    public String getFirstname(){return fname;}
    public String getLastname(){return lname;}
    public String getUsername(){return username;}
    public String getEmail(){return email;}
    public ArrayList<Game_type> getGames(){return games;}
    public int returnPoints(){return points;}
}
