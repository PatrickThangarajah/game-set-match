package com.example.game_set_match;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private String name;
    private List leaderboard;
    private List<User> users;

    public Game (String name, List leaderboard){
        this.name = name;
        this.leaderboard = leaderboard;
        users = new ArrayList<>();
    }

    public void addUser(User u){
        users.add(u);
    }

    public void deleteUser(User u){
        users.remove(u);
    }

    public String getName(){return name;}
    public List getLeaderboard(){return leaderboard;}
    public List<User> getUsers(){return users;}
}
