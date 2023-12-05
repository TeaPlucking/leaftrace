package com.datapirates.leaftrace;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class viewIssueActivity extends AppCompatActivity {
     TextView issueTextView;
     DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_issue);

        // Initialize TextView
        issueTextView = findViewById(R.id.viewIssues);

        // Initialize Firebase Database Reference
        databaseReference = FirebaseDatabase.getInstance().getReference().child("upload issue");

        // Read data from Firebase and set it to the TextView
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                StringBuilder issuesText = new StringBuilder();

                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    String issue = snapshot.child("Write Issue").getValue(String.class);
                    issuesText.append(issue).append("\n"); // Assuming each issue is on a new line
                }

                // Set the concatenated issues text to the TextView
                issueTextView.setText(issuesText.toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle errors, if any
            }
        });
    }
}