package com.datapirates.leaftrace;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class DashboardActivity extends AppCompatActivity {

    CardView pay, area, pro, about, setting, issues;
    ImageView home, issue, profile, settings;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        pay = findViewById(R.id.payment);
        area = findViewById(R.id.area);
        pro = findViewById(R.id.profile);
        about = findViewById(R.id.about);
        setting = findViewById(R.id.settings);
        issues = findViewById(R.id.issues);

        home = findViewById(R.id.home2);
        issue = findViewById(R.id.issues2);
        profile = findViewById(R.id.profile2);
        settings = findViewById(R.id.settings2);


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

        pro.setOnClickListener(new View.OnClickListener() {
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

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                settings();
            }
        });

        issues.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                issues();
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

    private void issues() {
        Intent intent = new Intent(this,IssuesActivity.class);
        startActivity(intent);
    }

    private void settings() {
        Intent intent = new Intent(this,settingsActivity.class);
        startActivity(intent);
    }

    private void about() {
        Intent intent = new Intent(this, about_activity.class);
        startActivity(intent);
    }


    private void profile() {
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }

    private void area() {
    }

    private void payment() {
        Intent intent = new Intent(this, PaymentActivity.class);
        startActivity(intent);
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