package com.datapirates.leaftrace;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.datapirates.leaftrace.DashboardActivity;
import com.datapirates.leaftrace.IssuesActivity;
import com.datapirates.leaftrace.ProfileActivity;
import com.datapirates.leaftrace.settingsActivity;

public class payrollActivity extends AppCompatActivity {

    ImageView home, issue, profile, settings;
    EditText pluckersId, bonusInput;
    Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payroll);

        home = findViewById(R.id.home6);
        issue = findViewById(R.id.issues6);
        profile = findViewById(R.id.profile6);
        settings = findViewById(R.id.settings6);

        pluckersId = findViewById(R.id.nameInput9);
        bonusInput = findViewById(R.id.nameInput11);
        calculateButton = findViewById(R.id.calbtn);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openhome();
            }
        });

        issue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openissue();
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openprofile();
            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opensettings();
            }
        });

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculatePayment();
            }
        });
    }

    private void opensettings() {
        Intent intent = new Intent(this, settingsActivity.class);
        startActivity(intent);
    }

    private void openprofile() {
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }

    private void openissue() {
        Intent intent = new Intent(this, IssuesActivity.class);
        startActivity(intent);
    }

    private void openhome() {
        Intent intent = new Intent(this, DashboardActivity.class);
        startActivity(intent);
    }

    private void calculatePayment() {
        // Retrieve bonus amount from input
        String bonusText = bonusInput.getText().toString();
        if (bonusText.isEmpty()) {
            Toast.makeText(this, "Please enter bonus amount", Toast.LENGTH_SHORT).show();
            return;
        }

        // Converting  bonus amount to double
        double bonus = Double.parseDouble(bonusText);

        // performing the bonus
        double payment = 10 * bonus;

        // Displaying  the result
        Toast.makeText(this, "Payment: " + payment, Toast.LENGTH_SHORT).show();
    }
}
