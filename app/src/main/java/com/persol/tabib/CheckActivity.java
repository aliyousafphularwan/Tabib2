package com.persol.tabib;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class CheckActivity extends AppCompatActivity {

    private TextView login;
    private TextView register;
    UserSession session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);

        login = findViewById(R.id.login_activity);
        register = findViewById(R.id.register_activity);

        session = new UserSession(this);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(CheckActivity.this, LoginActivity.class));

            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(CheckActivity.this, RegisterActivity.class));

            }
        });

    }
}
