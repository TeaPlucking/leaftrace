package com.datapirates.leaftrace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class loginScreenActivity extends AppCompatActivity {
    TextView signHere, forgetpwd;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        signHere = findViewById(R.id.signupHerebtn);
        login = findViewById(R.id.login);
        forgetpwd = findViewById(R.id.forgetPwdBtn);

        signHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSignupScreen();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDashboard();
            }
        });

        forgetpwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openForgetPwd();
            }
        });
    }

    private void openForgetPwd() {
        Intent intent = new Intent(this,forgotPasswordActivity.class);
        startActivity(intent);
    }

    private void openDashboard() {
        Intent intent = new Intent(this, DashboardActivity.class);
        startActivity(intent);
    }

    private void openSignupScreen() {
        Intent intent = new Intent(this, SignupScreen_Activity.class);
        startActivity(intent);
    }
}