package com.datapirates.leaftrace;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class recWeightActivity extends AppCompatActivity {

    private EditText pluckersIdInput, amountInput, areaInput, dateInput;
    private Button recordButton;
    private DatabaseReference weightReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rec_weight);

        initializeViews();

        // setting Firebase setup to store weight
        weightReference = FirebaseDatabase.getInstance().getReference("WeightRecords");

        recordButton.setOnClickListener(v -> recordWeight());
    }

    private void initializeViews() {
        pluckersIdInput = findViewById(R.id.nameInput2);
        amountInput = findViewById(R.id.nameInput3);
        areaInput = findViewById(R.id.nameInput4);
        dateInput = findViewById(R.id.nameInput5);
        recordButton = findViewById(R.id.recbtn);
    }

    // recording data
    private void recordWeight() {
        String pluckersId = pluckersIdInput.getText().toString().trim();
        String amount = amountInput.getText().toString().trim();
        String area = areaInput.getText().toString().trim();
        String date = dateInput.getText().toString().trim();

        if (pluckersId.isEmpty() || amount.isEmpty() || area.isEmpty() || date.isEmpty()) {
            Toast.makeText(recWeightActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
        } else {
            teaweightRecord weightRecord = new teaweightRecord(pluckersId, amount, area, date);

            // code to  Storing tea pluckers data in Firebase
            weightReference.push().setValue(weightRecord)
                    .addOnSuccessListener(aVoid -> {
                        Toast.makeText(recWeightActivity.this, "Recorded successfully", Toast.LENGTH_SHORT).show();
                        clearInputFields();
                    })
                    .addOnFailureListener(e ->
                            Toast.makeText(recWeightActivity.this, "Failed to record data", Toast.LENGTH_SHORT).show());
        }
    }

    private void clearInputFields() {
        pluckersIdInput.getText().clear();
        amountInput.getText().clear();
        areaInput.getText().clear();
        dateInput.getText().clear();
    }
}
