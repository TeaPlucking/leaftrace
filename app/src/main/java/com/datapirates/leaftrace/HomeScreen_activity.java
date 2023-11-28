package com.datapirates.leaftrace;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeScreen_activity extends AppCompatActivity {

    Button btn;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        btn = findViewById(R.id.homebutton);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLoginSignup();
            }
        });


    }

    private void openLoginSignup() {
        Intent intent = new Intent(this,login_signupActivity.class);
        startActivity(intent);
    }
}