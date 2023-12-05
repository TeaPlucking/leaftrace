package com.datapirates.leaftrace;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class recWeightActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rec_weight);

        // Finding  views by their IDs
        EditText pluckersIdInput = findViewById(R.id.nameInput2);
        EditText amountInput = findViewById(R.id.nameInput3);
        EditText areaInput = findViewById(R.id.nameInput4);
        EditText dateInput = findViewById(R.id.nameInput5);
        Button recordButton = findViewById(R.id.recbtn);

        // Setting  click listener for the record button
        recordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Getting  values from input fields
                String pluckersId = pluckersIdInput.getText().toString().trim();
                String amount = amountInput.getText().toString().trim();
                String area = areaInput.getText().toString().trim();
                String date = dateInput.getText().toString().trim();

                // Checking if any field is empty
                if (pluckersId.isEmpty() || amount.isEmpty() || area.isEmpty() || date.isEmpty()) {
                    Toast.makeText(recWeightActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                } else {

                    Toast.makeText(recWeightActivity.this, "Recorded: " + pluckersId + ", " + amount + " KG, " + area + ", " + date, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
