package com.datapirates.leaftrace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class loginScreenActivity extends AppCompatActivity {
    TextView signHere, forgetpwd;
    TextView enter_Username, enter_Password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        // Validation of the Login Screen

        enter_Username = findViewById(R.id.login_input);
        enter_Password = findViewById(R.id.password_input1);



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
                if (enter_Username.getText().toString().equals("admin") && enter_Password.getText().toString().equals("admin")) {
                    // Correct credentials for tea pluckers
                    Toast.makeText(loginScreenActivity.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(loginScreenActivity.this, DashboardActivity.class);
                    startActivity(intent);
                } else if (enter_Username.getText().toString().equals("plantation staff") && enter_Password.getText().toString().equals("2001")) {
                    // Correct credentials for plantation staff
                    Toast.makeText(loginScreenActivity.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(loginScreenActivity.this,mgrDashboardActivity.class);
                    startActivity(intent);
                } else {
                    // Incorrect credentials
                    Toast.makeText(loginScreenActivity.this, "Incorrect Login Credentials", Toast.LENGTH_SHORT).show();

                }
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