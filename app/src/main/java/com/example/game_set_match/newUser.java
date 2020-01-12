package com.example.game_set_match;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class newUser extends AppCompatActivity {
    String fname;
    String lname;
    String username;
    String email;
    String password;

    public void setfirstname(String name){
        this.fname = name;
    }

    public void setlastname(String name){
        this.lname = name;
    }

    public void setusername(String name){
        this.username = name;
    }

    public void setemail(String email){
        this.username = email;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }
}