package com.persol.tabib;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    private Button login;
    private TextView forget_pass;
    private EditText etUSer, etPass;
    UserSession session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        session = new UserSession(this);

        forget_pass = findViewById(R.id.forget_pass);
        etUSer = findViewById(R.id.et_user);
        etPass = findViewById(R.id.et_passin);

        login = findViewById(R.id.btnLogin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                login();


            }
        });

        forget_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(LoginActivity.this, ForgetActivity.class));

            }
        });

    }

    private void login() {

        final String username = etUSer.getText().toString().trim();
        final String password = etPass.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, Constants.LOGIN_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jo = new JSONObject(response);
                    //Toast.makeText(LoginActivity.this, "response: " + jo.getString("success"), Toast.LENGTH_SHORT).show();
                    String success = jo.getString("success");
                    String id = jo.getString("id");
                    if (success.equals("1")){
                        //Toast.makeText(LoginActivity.this, "success", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(LoginActivity.this, DashboardActivity.class);
                        i.putExtra("id", id);
                        startActivity(i);
                        finish();
                    }else{
                        Toast.makeText(LoginActivity.this, jo.getString("message"), Toast.LENGTH_SHORT).show();
                        etUSer.setText("");
                        etPass.setText("");
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(LoginActivity.this, "error: " + error.toString(), Toast.LENGTH_SHORT).show();
            }
        }){

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();

                params.put("email", username);
                params.put("password", password);

                return params;

            }
        };

        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(stringRequest);

    }
}
