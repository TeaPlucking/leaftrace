package com.datapirates.leaftrace;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignupScreen_Activity extends AppCompatActivity {

    // declaring UI elements of the leaf trace application
    Button signup;
    TextView loginHere;
    EditText editTextEmail ,editTextManagerid,editTextUsername,editTextPwd,editTextRePwd, editTextname;

    // declaring firebase variables

    FirebaseDatabase database;
    DatabaseReference reference;


    private FirebaseAuth auth;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_screen);

        signup = findViewById(R.id.signupbtn);
        loginHere = findViewById(R.id.loginHereBtn);
        editTextEmail = findViewById(R.id.emailInput);
        editTextManagerid = findViewById(R.id.mngrIdInput);
        editTextUsername = findViewById(R.id.UsernameInput);
        editTextPwd =findViewById(R.id.pwdInput);
        editTextRePwd = findViewById(R.id.rePwdInput);
        editTextname = findViewById(R.id.nameInput);


        auth = FirebaseAuth.getInstance();

        // adding error messages for each columns in the sign up page
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.signupbtn:
                        String email, managerid, username, pwd, repwd, name;
                        email = editTextEmail.getText().toString();
                        managerid = editTextManagerid.getText().toString();
                        username = editTextUsername.getText().toString();
                        pwd = editTextPwd.getText().toString();
                        repwd = editTextRePwd.getText().toString();
                        name = editTextname.getText().toString();

                        if (email.equals("") || managerid.equals("") ||  username.equals("") || pwd.equals("") || repwd.equals("")) {
                            Toast.makeText(SignupScreen_Activity.this, "Fields can't be empty", Toast.LENGTH_SHORT).show();
                        } else {
                            if (pwd.length() < 6) {
                                Toast.makeText(SignupScreen_Activity.this, "Password should have at least 6 characters", Toast.LENGTH_SHORT).show();
                            } else if (!pwd.equals(repwd)) {
                                Toast.makeText(SignupScreen_Activity.this, "Password does not match", Toast.LENGTH_SHORT).show();
                            }else if (!pwd.equals(name)) {
                                    Toast.makeText(SignupScreen_Activity.this, "Name Cannot be Empty", Toast.LENGTH_SHORT).show();
                            } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                                Toast.makeText(SignupScreen_Activity.this, "Email should be in a valid format", Toast.LENGTH_SHORT).show();
                            } else {
                                auth.createUserWithEmailAndPassword(email,pwd).addOnCompleteListener(SignupScreen_Activity.this, sign ->{
                                    if (sign.isSuccessful()){
                                        Toast.makeText(SignupScreen_Activity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(SignupScreen_Activity.this, loginScreenActivity.class);
                                        startActivity(intent);
                                    }
                                    else {
                                        Exception exception = sign.getException();
                                        if (exception instanceof FirebaseAuthUserCollisionException) {
                                            // Handle case where email is already in use
                                            Toast.makeText(SignupScreen_Activity.this, "Email is already in use", Toast.LENGTH_SHORT).show();
                                        } else {
                                            // Handle other registration failures
                                            Toast.makeText(SignupScreen_Activity.this, "Registration Failed: " + exception.getMessage(), Toast.LENGTH_SHORT).show();
                                            }
                                    }
                                });
                            }
                        }
                        break;
                }
            }
        };

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // initializing firebase database
                database = FirebaseDatabase.getInstance();
                reference = database.getReference("Users");

                // Extract input values
                String Username = editTextUsername.getText().toString();
                String email = editTextEmail.getText().toString();
                String ManagerID= editTextManagerid.getText().toString();
                String password = editTextPwd.getText().toString();
                String ConfirmPassword = editTextRePwd.getText().toString();
                String name = editTextname.getText().toString();

                // Create a HelperClass instance to store user data before saving it to the Firebase Realtime Database
                HelperClass helperClass = new HelperClass(Username, email, ManagerID, password, ConfirmPassword,name);
                reference.child(Username).setValue(helperClass);

                Toast.makeText(SignupScreen_Activity.this, "you have signed up Successfully!",Toast.LENGTH_SHORT).show();
                Intent intent  = new Intent(SignupScreen_Activity.this, loginScreenActivity.class);
                startActivity(intent);

            }
        });

        loginHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignupScreen_Activity.this, loginScreenActivity.class);
                startActivity(intent);

            }
        });
    }
}