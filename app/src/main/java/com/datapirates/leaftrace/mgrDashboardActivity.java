package com.datapirates.leaftrace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class  mgrDashboardActivity extends AppCompatActivity {

    ImageView payroll, update, record, checkissues;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mgr_dashboard);

        payroll = findViewById(R.id.payment_img2);
        update = findViewById(R.id.areaimg2);
        record = findViewById(R.id.chkweight);
        checkissues = findViewById(R.id.issue_img2);

        payroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pay();
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updatedetail();
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


    }

    private void issues() {
        Intent intent = new Intent(this,viewIssueActivity.class);
        startActivity(intent);
    }

    private void recorddetail() {
        Intent intent = new Intent(this,recWeightActivity.class);
        startActivity(intent);
    }

    private void updatedetail() {

    }

    private void pay() {
        Intent intent = new Intent(this,payrollActivity.class);
        startActivity(intent);
    }


}