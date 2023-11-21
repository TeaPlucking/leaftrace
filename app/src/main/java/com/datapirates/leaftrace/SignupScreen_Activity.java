package com.datapirates.leaftrace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class SignupScreen_Activity extends AppCompatActivity {
    Button signup;
    TextView loginHere;
    EditText editTextEmail ,editTextManagerid,editTextUsername,editTextPwd,editTextRePwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_screen);

        signup = findViewById(R.id.signupbtn);
        loginHere = findViewById(R.id.loginHereBtn);
        editTextEmail = findViewById(R.id.emailInput);
        editTextManagerid = findViewById(R.id.mngrIdInput2);
        editTextUsername = findViewById(R.id.nameInput);
        editTextPwd =findViewById(R.id.pwdInput);
        editTextRePwd = findViewById(R.id.rePwdInput);


        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.loginHereBtn:
                        Intent intent = new Intent(SignupScreen_Activity.this, loginScreenActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.signupbtn:
                        String email, managerid, username, pwd, repwd;
                        email = editTextEmail.getText().toString();
                        managerid = editTextManagerid.getText().toString();
                        username = editTextUsername.getText().toString();
                        pwd = editTextPwd.getText().toString();
                        repwd = editTextRePwd.getText().toString();

                        if (email.equals("") ||  username.equals("") || pwd.equals("") || repwd.equals("")) {
                            Toast.makeText(SignupScreen_Activity.this, "Fields can't be empty", Toast.LENGTH_SHORT).show();
                        } else {
                            if (pwd.length() < 4) {
                                Toast.makeText(SignupScreen_Activity.this, "Password should have at least 4 characters", Toast.LENGTH_SHORT).show();
                            } else if (!pwd.equals(repwd)) {
                                Toast.makeText(SignupScreen_Activity.this, "Password does not match", Toast.LENGTH_SHORT).show();
                            } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                                Toast.makeText(SignupScreen_Activity.this, "Email should be in a valid format", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(SignupScreen_Activity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                                intent = new Intent(SignupScreen_Activity.this, loginScreenActivity.class);
                                startActivity(intent);
                            }
                        }
                        break;
                }
            }
        };

        signup.setOnClickListener(onClickListener);
        loginHere.setOnClickListener(onClickListener);
    }
}