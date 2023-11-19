package com.datapirates.leaftrace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SignupScreen_Activity extends AppCompatActivity {
    Button signup;
    TextView loginHere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_screen);

        signup = findViewById(R.id.signupbtn);
        loginHere = findViewById(R.id.loginHereBtn);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLoginscreen();
            }
        });

        loginHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLoginScreen();
            }
        });
    }

    private void openLoginscreen() {
        Intent intent = new Intent(this, loginScreenActivity.class);
        startActivity(intent);
    }

    private void openLoginScreen() {
        Intent intent = new Intent(this, loginScreenActivity.class);
        startActivity(intent);
    }

}