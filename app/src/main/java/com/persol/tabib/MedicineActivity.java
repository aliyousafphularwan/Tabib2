package com.persol.tabib;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MedicineActivity extends AppCompatActivity {

    TextView medName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine);

        medName = findViewById(R.id.med_name);

        Intent intent = getIntent();
        String med_name = intent.getStringExtra("name");
        medName.setText(med_name);

    }
}
