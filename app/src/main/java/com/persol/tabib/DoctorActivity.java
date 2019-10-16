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

        // getSupportActionBar().hide();

//        Intent intent = getIntent();
//        String gname = intent.getStringExtra("name");
//        String gemail = intent.getStringExtra("email");
//
//        name = findViewById(R.id.tvName);
//        name.setText(gname);
//        email=findViewById(R.id.tvEmail);
//        email.setText(gemail);

    }
}
