package com.datapirates.leaftrace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class settingsActivity extends AppCompatActivity {

        ImageView home, issue, profile, settings;

        EditText name, email, telNo, Password;
        Button saveChanges;
        String nameUser, emailUser, telUser, userPassword;
        DatabaseReference reference;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_settings);

            home = findViewById(R.id.home8);
            issue = findViewById(R.id.issues8);

            profile = findViewById(R.id.profile8);
            settings = findViewById(R.id.settings8);

            reference = FirebaseDatabase.getInstance().getReference("Users");

            name = findViewById(R.id.Name);
            email = findViewById(R.id.email);
            telNo = findViewById(R.id.telno);
            Password = findViewById(R.id.password);
            saveChanges = findViewById(R.id.button3);

            showData();

            saveChanges.setOnClickListener(new View.OnClickListener() {
                @Override

                public void onClick(View v) {
                    if (isNameChanged() || isEmailChanged() || isPasswordChanged()) {
                        Toast.makeText(settingsActivity.this, "Saved", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(settingsActivity.this, "No changes found", Toast.LENGTH_SHORT).show();
                    }
                }
            });

            home.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openHome();

                }
            });

            issue.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openIssue();
                }
            });

            profile.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openProfile();
                }
            });

            settings.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    openSettings();
                }
            });
        }

        private void openSettings() {
        }

        private void opensettings() {
            Intent intent = new Intent(this, settingsActivity.class);
            startActivity(intent);
        }

        private void openProfile() {
            Intent intent = new Intent(this, ProfileActivity.class);
            startActivity(intent);
        }


        private void openIssue() {
            Intent intent = new Intent(this, IssuesActivity.class);
            startActivity(intent);
        }

        private void openHome() {
            Intent intent = new Intent(this, DashboardActivity.class);
            startActivity(intent);
        }

        public boolean isNameChanged() {
            if (!nameUser.equals(name.getText().toString())) {
                reference.child(telUser).child("name").setValue(name.getText().toString());
                nameUser =

                        name.getText().toString();
                return true;
            } else {
                return false;
            }
        }

        public boolean isEmailChanged() {
            if (!emailUser.equals(email.getText().toString())) {
                reference.child(telUser).child("email").setValue(email.getText().toString());
                emailUser = email.getText().toString();
                return true;
            } else {
                return false;
            }
        }


        public boolean isPasswordChanged() {
            if (!userPassword.equals(Password.getText().toString())) {
                reference.child(telUser).child("password").setValue(Password.getText().toString());
                userPassword = Password.getText().toString();
                return true;
            } else {
                return false;
            }
        }

        public void showData() {
            nameUser = getIntent().getStringExtra("name");
            emailUser = getIntent().getStringExtra("email");

            telUser = getIntent().getStringExtra("telNo");
            userPassword = getIntent().getStringExtra("Password");

            name.setText(nameUser);
            email.setText(emailUser);
            telNo.setText(telUser);
            Password.setText(userPassword);
        }
    }

