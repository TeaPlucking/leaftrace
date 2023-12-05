package com.datapirates.leaftrace;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.Firebase;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class IssuesActivity extends AppCompatActivity {
    ImageView home, issue, profile, settings;
    EditText writeissue;
    Button postissue;

    FirebaseDatabase firebaseDatabase;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_issues);

        home = findViewById(R.id.home4);
        issue = findViewById(R.id.issues4);
        profile = findViewById(R.id.profile4);
        settings = findViewById(R.id.settings4);
        writeissue = findViewById(R.id.editTextTextMultiLine2);
        postissue = findViewById(R.id.postbtn);
        firebaseDatabase = FirebaseDatabase.getInstance();

        postissue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HashMap<String ,Object>map = new HashMap<>();
                map.put("Write Issue",writeissue.getText().toString());
                firebaseDatabase.getReference().child("upload issue").push().setValue(map)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(IssuesActivity.this, "upload sucessfull", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(IssuesActivity.this, "Error", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openhome();
            }
        });

        issue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openissue();
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openprofile();
            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opensettings();
            }
        });

    }

    private void opensettings() {
        Intent intent = new Intent(this,settingsActivity.class);
        startActivity(intent);
    }

    private void openprofile() {
        Intent intent = new Intent(this,ProfileActivity.class);
        startActivity(intent);
    }

    private void openissue() {
        Intent intent = new Intent(this,IssuesActivity.class);
        startActivity(intent);
    }

    private void openhome() {
        Intent intent = new Intent(this,DashboardActivity.class);
        startActivity(intent);
    }
}