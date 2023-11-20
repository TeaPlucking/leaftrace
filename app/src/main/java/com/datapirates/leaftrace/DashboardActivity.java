package com.datapirates.leaftrace;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DashboardActivity extends AppCompatActivity {

    CardView pay, area, profile, about, issues;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        pay = findViewById(R.id.payment);
        area = findViewById(R.id.area);
        profile = findViewById(R.id.profile);
        about = findViewById(R.id.about);
        issues = findViewById(R.id.issues);


        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                payment();
            }
        });

        area.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                area();
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                profile();
            }
        });

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                about();
            }
        });


        issues.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                issues();
            }
        });
    }

    private void issues() {
        Intent intent = new Intent(this,IssuesActivity.class);
        startActivity(intent);
    }


    private void about() {
        Intent intent = new Intent(this, about_activity.class);
        startActivity(intent);
    }


    private void profile() {
        Intent intent = new Intent(this, profileActivity.class);
        startActivity(intent);
    }

    private void area() {
    }

    private void payment() {
    }
}