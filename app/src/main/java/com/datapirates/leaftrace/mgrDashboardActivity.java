package com.datapirates.leaftrace;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class  mgrDashboardActivity extends AppCompatActivity {

    ImageView payroll, record, checkissues, home, settings;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mgr_dashboard);

        payroll = findViewById(R.id.payment_img2);
        record = findViewById(R.id.chkweight);
        checkissues = findViewById(R.id.issue_img2);

        home = findViewById(R.id.imageView16);
        settings= findViewById(R.id.imageView111);


        payroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pay();
            }
        });


        record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recorddetail();
            }
        });

        checkissues.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                issues();
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mgrDashboardActivity.this, mgrDashboardActivity.class);
            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mgrDashboardActivity.this, settingsActivity.class);
            }
        });





    }

    private void issues() {
        Intent intent = new Intent(this,viewIssueActivity.class);
        startActivity(intent);
    }

    private void recorddetail() {
        Intent intent = new Intent(this,recWeightActivity.class);
        startActivity(intent);
    }


    private void pay() {
        Intent intent = new Intent(this,payrollActivity.class);
        startActivity(intent);
    }


}