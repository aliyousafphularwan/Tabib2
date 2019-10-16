package com.persol.tabib;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.persol.tabib.Adapters.DoctorAdapter;

public class DoctorActivity extends AppCompatActivity {

    TextView name, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);

        name = findViewById(R.id.tvName);
        email = findViewById(R.id.tvEmail);

        Intent intent = getIntent();
        String gname = intent.getStringExtra("name");
        String specialty = intent.getStringExtra("specialty");

        name.setText(gname);
        email.setText(specialty);


    }
}
