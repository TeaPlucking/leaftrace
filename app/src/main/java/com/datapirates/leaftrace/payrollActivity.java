package com.datapirates.leaftrace;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class payrollActivity extends AppCompatActivity {

    ImageView home, settings;
    EditText pluckersId, bonusInput;
    Button calculateButton;

    DatabaseReference paymentReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payroll);

        initializeViews();

        paymentReference = FirebaseDatabase.getInstance().getReference("Payments");

        setOnClickListeners();
    }

    private void initializeViews() {
        home = findViewById(R.id.home6);
        settings = findViewById(R.id.settings6);

        pluckersId = findViewById(R.id.nameInput9);
        bonusInput = findViewById(R.id.nameInput11);
        calculateButton = findViewById(R.id.calbtn);
    }

    private void setOnClickListeners() {
        home.setOnClickListener(v -> openActivity(DashboardActivity.class));
        settings.setOnClickListener(v -> openActivity(settingsActivity.class));

        calculateButton.setOnClickListener(v -> calculateAndStorePayment());
    }

    private void openActivity(Class<?> activityClass) {
        Intent intent = new Intent(this, activityClass);
        startActivity(intent);
    }

    // code for calculating the tea plucker's payment with bonus and amount

    private void calculateAndStorePayment() {
        String pluckersIdText = pluckersId.getText().toString().trim();
        String bonusText = bonusInput.getText().toString().trim();

        if (pluckersIdText.isEmpty() || bonusText.isEmpty()) {
            Toast.makeText(this, "Please enter pluckers' ID and bonus amount", Toast.LENGTH_SHORT).show();
            return;
        }

        // the above code is used to get the amount of the tea pluckers as rupees here 10 is used as a demonstration example for the app
        double bonus = Double.parseDouble(bonusText);
        double payment = 10 * bonus;

        // code for Storing payment details of tea pluckers  in Firebase database
        PaymentInfo paymentInfo = new PaymentInfo(pluckersIdText, bonus, payment);
        paymentReference.child(pluckersIdText).setValue(paymentInfo)
                .addOnSuccessListener(aVoid -> {
                    Toast.makeText(this, "Payment stored successfully", Toast.LENGTH_SHORT).show();
                    clearInputFields();
                })
                .addOnFailureListener(e ->
                        Toast.makeText(this, "Failed to store payment information", Toast.LENGTH_SHORT).show());
    }
    // getting values of payments
    private void clearInputFields() {
        pluckersId.getText().clear();
        bonusInput.getText().clear();
    }
}
