package com.persol.tabib;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
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

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText et_name, et_email, et_pass, et_phone;
    private Spinner blood_group;
    private Button btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        et_name = findViewById(R.id.et_name);
        et_email = findViewById(R.id.et_email);
        et_pass = findViewById(R.id.et_pass);
        et_phone = findViewById(R.id.et_phone);
        blood_group = findViewById(R.id.blood_group);
        btnSignup = findViewById(R.id.btnSignup);
        btnSignup.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        if (v == btnSignup){

            registerUser();

        }

    }

    private void registerUser() {

        final String name = et_name.getText().toString().trim();
        final String email = et_email.getText().toString().trim();
        final String pass = et_pass.getText().toString().trim();
        final String phone = et_phone.getText().toString().trim();
        final String bgroup = blood_group.getSelectedItem().toString();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, Constants.SIGNUP_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try{

                    JSONObject jo = new JSONObject(response);
                    Toast.makeText(RegisterActivity.this, "message: " + jo.getString("message"), Toast.LENGTH_SHORT).show();

                    et_name.setText("");
                    et_email.setText("");
                    et_pass.setText("");
                    et_phone.setText("");

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(RegisterActivity.this, "error: " + error.toString(), Toast.LENGTH_SHORT).show();
                et_name.setText("");
                et_email.setText("");
                et_pass.setText("");
                et_phone.setText("");

            }
        }){

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();

                params.put("name", name);
                params.put("email", email);
                params.put("password", pass);
                params.put("blood_group", bgroup);
                params.put("phone", phone);

                return params;

            }
        };

        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(stringRequest);

    }
}
