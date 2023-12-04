package com.datapirates.leaftrace;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class loginScreenActivity extends AppCompatActivity {
    TextView signHere, forgetPwd;
    TextView enterUsername, enterPassword;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        enterUsername = findViewById(R.id.login_input);
        enterPassword = findViewById(R.id.password_input1);

        signHere = findViewById(R.id.signupHerebtn);
        login = findViewById(R.id.login);
        forgetPwd = findViewById(R.id.forgetPwdBtn);

        signHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSignupScreen();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateUsername() && validatePassword()) {
                    checkUser();
                }
            }
        });

        forgetPwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openForgetPwd();
            }
        });
        return;
    }

    public boolean validateUsername() {
        String username = enterUsername.getText().toString().trim();
        if (username.isEmpty()) {
            enterUsername.setError("Username cannot be empty");
            return false;
        } else {
            enterUsername.setError(null);
            return true;
        }
    }

    public boolean validatePassword() {
        String password = enterPassword.getText().toString().trim();
        if (password.isEmpty()) {
            enterPassword.setError("Password cannot be empty");
            return false;
        } else {
            enterPassword.setError(null);
            return true;
        }
    }

    public void checkUser() {
        String userUsername = enterUsername.getText().toString().trim();
        String userPassword = enterPassword.getText().toString().trim();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Users");
        Query checkUserDatabase = reference.orderByChild("editTextUsername").equalTo(userUsername);

        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    enterUsername.setError(null);
                    String role = snapshot.child(userUsername).child("editTextPwd").getValue(String.class);

                    if (userUsername.startsWith("p") && role.equals(userPassword)) {
                        if (Objects.equals(snapshot.child(userUsername).child("editTextPwd").getValue(String.class), userPassword)) {
                            openDashboard();
                        } else {
                            enterPassword.setError("Invalid Credentials");
                            enterPassword.requestFocus();
                        }
                    } else if (userUsername.startsWith("m") && role.equals(userPassword)) {
                        if (Objects.equals(snapshot.child(userUsername).child("editTextPwd").getValue(String.class), userPassword)) {
                            openManagerDashboard();
                        } else {
                            enterPassword.setError("Invalid Credentials");
                            enterPassword.requestFocus();
                        }
                    } else {
                        enterUsername.setError("Invalid User Type");
                        enterUsername.requestFocus();
                    }
                } else {
                    enterUsername.setError("User does not exist");
                    enterUsername.requestFocus();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle onCancelled
            }
        });
    }

    private void openDashboard() {
        Intent intent = new Intent(loginScreenActivity.this, DashboardActivity.class);
        startActivity(intent);
    }

    private void openManagerDashboard() {
        Intent intent = new Intent(loginScreenActivity.this, mgrDashboardActivity.class);
        startActivity(intent);
    }

    private void openForgetPwd() {
        Intent intent = new Intent(loginScreenActivity.this, forgotPasswordActivity.class);
        startActivity(intent);
    }

    private void openSignupScreen() {
        Intent intent = new Intent(loginScreenActivity.this, SignupScreen_Activity.class);
        startActivity(intent);
    }
}
