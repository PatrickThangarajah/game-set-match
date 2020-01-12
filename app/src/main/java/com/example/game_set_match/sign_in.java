package com.example.game_set_match;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class sign_in extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        Button btn = (Button) findViewById(R.id.signinbutton);
        final FirebaseFirestore db = FirebaseFirestore.getInstance();
        final EditText userEdit = findViewById(R.id.usernameField);
        final EditText pwEdit = findViewById(R.id.editText2);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String username = userEdit.getText().toString();
                final String pass= pwEdit.getText().toString();

                db.collection("Users").document(username).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {

                        DocumentSnapshot documentSnapshot = task.getResult();

                        if (documentSnapshot.exists() &&
                                documentSnapshot.get("pw").toString().equals(pass)) {
                            Intent intent = new Intent(getApplicationContext(),QR.class);
                            intent.putExtra("username",username);
                            startActivity(intent);
                        }
                    }
                });

            }
        });
    }
    //private void validate(String userName, String userPassword){}
}
