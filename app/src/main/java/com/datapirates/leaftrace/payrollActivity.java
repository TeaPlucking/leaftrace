package com.datapirates.leaftrace;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class payrollActivity extends AppCompatActivity {

    ImageView home, issue, profile, settings;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payroll);

        home = findViewById(R.id.home6);
        issue = findViewById(R.id.issues6);
        profile = findViewById(R.id.profile6);
        settings = findViewById(R.id.settings6);

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