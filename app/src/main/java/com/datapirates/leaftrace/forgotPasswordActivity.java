package com.datapirates.leaftrace;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Firebase;
import com.google.firebase.auth.FirebaseAuth;

public class forgotPasswordActivity extends AppCompatActivity {

    EditText reset;
    Button cancel, submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        reset = findViewById(R.id.resetemail_input);
        cancel = findViewById(R.id.cancelbtn);
        submit = findViewById(R.id.submitbtn);

        FirebaseAuth auth = FirebaseAuth.getInstance();

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = reset.getText().toString();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplication(), "Enter your registered email id", Toast.LENGTH_SHORT).show();
                    return;
                }

                auth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(forgotPasswordActivity.this, "Registration link send sucessfully. Check your email ", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(forgotPasswordActivity.this, "Failed to send the reset link", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });


    }

    private void login() {
        Intent intent = new Intent(this,loginScreenActivity.class);
        startActivity(intent);
    }


}
