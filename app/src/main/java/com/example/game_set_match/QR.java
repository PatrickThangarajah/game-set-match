package com.example.game_set_match;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.Map;

public class QR extends AppCompatActivity {
    private String GetQrApiUrl(String username) {
        return GetQrApiUrl(username,500,500);
    }

    private String GetQrApiUrl(String username, int width, int length) {
        Map<String,String> params = new HashMap<>();
        char andSymbol = '&';

        params.put("baseUrl","https://chart.googleapis.com/chart?");
        params.put("chartType","cht=qr");
        params.put("dimensions",String.format("chs=%dx%d",width,length));
        params.put("data",String.format("chl=%s",username));

        return params.get("baseUrl") +
                andSymbol +
                params.get("chartType") +
                andSymbol +
                params.get("dimensions") +
                andSymbol +
                params.get("data");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr);
        final FirebaseFirestore db = FirebaseFirestore.getInstance();

        final String username = getIntent().getStringExtra("username");
        final ImageView qrImageView = findViewById(R.id.ImageView_QR);
        qrImageView.setOnClickListener(openQrCamera);
        // load QR code (google API) into View



        db.collection("Active_Games").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                if(queryDocumentSnapshots.isEmpty())
                {
                    while(true){
                        Log.v("app","hello");
                    }
                };
                for (DocumentSnapshot doc : queryDocumentSnapshots){
                    if (doc.get("Player1").toString().equals(username) ||
                            doc.get("Player2").toString().equals(username)
                    ){
                        Intent intent = new Intent(getApplicationContext(),Ending_MatchScreen.class);
                        String opponent = (doc.get("Player1").toString().equals(username)) ?
                                doc.get("Player2").toString() :
                                doc.get("Player1").toString();
                        intent.putExtra("username",username);
                        intent.putExtra("opponent",opponent);
                        startActivity(intent);
                    }
                }
            }
        });

        db.collection("Users")
                .document(username)
                .get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                User user = docToUser(documentSnapshot);
                Picasso.get().load(GetQrApiUrl(user.getUsername())).into(qrImageView);
                db.collection("SeekingPlayers").document(username).set(new HashMap<>());

            }
        });

    }

    private User docToUser(DocumentSnapshot d) {
        return new User(
                d.get("fname").toString(),
                d.get("lname").toString(),
                d.get("username").toString(),
                d.get("email").toString(),
                d.get("pw").toString());
    }

    View.OnClickListener openQrCamera = new View.OnClickListener(){
        public void onClick (View v) {
            Intent intent = new Intent(v.getContext(), BarcodeReaderActivity.class);
            intent.putExtra("username",getIntent().getStringExtra("username"));
            startActivity(intent);
        }
    };
}
