package com.example.game_set_match;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class SignUpActivity extends AppCompatActivity {
    private Button back;
    private Button enter;
    private EditText fname=null;
    private EditText lname=null;
    private EditText uname=null;
    private EditText mail=null;
    private EditText pw=null;
    private String firstname;
    private String lastname;
    private String username;
    private String email;
    private String password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        back =(Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openback();
            }
        });



        fname=(EditText) findViewById(R.id.firstname);
        lname=(EditText) findViewById(R.id.lastname);
        uname=(EditText) findViewById(R.id.username);
        mail=(EditText) findViewById(R.id.setemail);
        pw= (EditText) findViewById(R.id.setpassword);

        enter=(Button) findViewById(R.id.enter);
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstname=fname.getText().toString();
                lastname=lname.getText().toString();
                username=uname.getText().toString();
                email=mail.getText().toString();
                password=pw.getText().toString();

                //new User(firstname,lastname,username,email,password);
                openenter();
            }
        });
    }
    public void openback() {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);}
    public void openenter() {

         if(!(firstname.equals(""))&&!(lastname.equals(""))&&!(username.equals(""))&&!(email.equals(""))&&!(password.equals(""))){
            Intent intent = new Intent(this, sign_in.class);
            startActivity(intent);}

    }
}
