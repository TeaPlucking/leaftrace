package com.datapirates.leaftrace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class login_signupActivity extends AppCompatActivity {
    Button logbtn, signupbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_signup);

        logbtn = findViewById(R.id.log);
        signupbtn = findViewById(R.id.signup);

        logbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLoginScreen();
            }
        });

        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSignupScreen();
            }
        });

    }

    private void openLoginScreen() {
        Intent intent = new Intent(this,loginScreenActivity.class);
        startActivity(intent);
    }

    private void openSignupScreen() {
        Intent intent = new Intent(this,SignupScreen_Activity.class);
        startActivity(intent);
    }
}