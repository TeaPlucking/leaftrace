// LoginScreenActivity.java

package com.datapirates.leaftrace;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class loginScreenActivity extends AppCompatActivity {
    private EditText enterUsername, enterPassword;
    private Button login;
    private TextView signHere, forgetPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        // Initialize views
        enterUsername = findViewById(R.id.login_input);
        enterPassword = findViewById(R.id.password_input1);
        signHere = findViewById(R.id.signupHerebtn);
        login = findViewById(R.id.login);
        forgetPwd = findViewById(R.id.forgetPwdBtn);

        // Set click listeners
        signHere.setOnClickListener(v -> openSignupScreen());

        login.setOnClickListener(v -> {
            if (validateInput()) {
                checkUser();
            }
        });

        forgetPwd.setOnClickListener(v -> openForgetPwd());
    }

    private boolean validateInput() {
        String username = enterUsername.getText().toString().trim();
        String password = enterPassword.getText().toString().trim();

        if (username.isEmpty()) {
            enterUsername.setError("Username cannot be empty");
            return false;
        } else if (password.isEmpty()) {
            enterPassword.setError("Password cannot be empty");
            return false;
        }

        return true;
    }

    private void checkUser() {
        String userUsername = enterUsername.getText().toString().trim();
        String userPassword = enterPassword.getText().toString().trim();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Users");
        Query checkUserDatabase = reference.orderByChild("editTextUsername").equalTo(userUsername);

        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    enterUsername.setError(null);
                    String role = Objects.requireNonNull(snapshot.child(userUsername).child("editTextPwd").getValue(String.class));

                    if ((userUsername.startsWith("p") || userUsername.startsWith("m")) && role.equals(userPassword)) {
                        openDashboard(userUsername);
                    } else {
                        enterPassword.setError("Invalid Credentials");
                        enterPassword.requestFocus();
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

    private void openDashboard(String userUsername) {
        Intent intent;
        if (userUsername.startsWith("p")) {
            intent = new Intent(loginScreenActivity.this, DashboardActivity.class);
        } else {
            intent = new Intent(loginScreenActivity.this, mgrDashboardActivity.class);
        }

        // Pass data to SettingsActivity
        intent.putExtra("name", "John Doe");
        intent.putExtra("email", "john.doe@example.com");
        intent.putExtra("telNo", "1234567890");
        intent.putExtra("Password", "dummyPassword");

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
