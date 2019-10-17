package com.persol.tabib;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.persol.tabib.Adapters.DocAdapter;
import com.persol.tabib.Adapters.DoctorAdapter;
import com.persol.tabib.Misc.DoctorModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class DoctorActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DocAdapter docAdapter;
    private ArrayList<DoctorModel> dList;
    private RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);

        recyclerView = findViewById(R.id.docList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        dList = new ArrayList<>();

        mQueue = Volley.newRequestQueue(this);
        getData();

    }

    private void getData() {

        StringRequest request = new StringRequest(Request.Method.GET, Constants.DOC, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject obj = new JSONObject(response);
                    String success = obj.getString("success");
                    if (success.equals("1")){
                        JSONArray arr = obj.getJSONArray("data");
                        for (int i=0;i<arr.length();i++){
                            JSONObject data = arr.getJSONObject(i);
                            String name = data.getString("name");
                            String degree = data.getString("designation");

                            dList.add(new DoctorModel(name, degree));
                        }
                    }

                    docAdapter = new DocAdapter(DoctorActivity.this, dList);
                    recyclerView.setAdapter(docAdapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        mQueue.add(request);

    }
}
