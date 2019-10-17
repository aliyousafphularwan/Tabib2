package com.persol.tabib;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.persol.tabib.Adapters.MedicineAdapter;
import com.persol.tabib.Misc.MedicineModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MedicineActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MedicineAdapter medicineAdapter;
    private ArrayList<MedicineModel> medList;
    private RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine);

        recyclerView = findViewById(R.id.medList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        medList = new ArrayList<>();

        mQueue = Volley.newRequestQueue(this);

        getData();


    }

    private void getData() {

        StringRequest request = new StringRequest(Request.Method.GET, Constants.MED, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jo = new JSONObject(response);
                        String success = jo.getString("success");
                        if (success.equals("1")){
                            //Toast.makeText(MedicineActivity.this, "Response: " + success, Toast.LENGTH_SHORT).show();
                            JSONArray ja = jo.getJSONArray("data");
                            for (int i = 0;i < ja.length();i++){
                                JSONObject data = ja.getJSONObject(i);
                                String name = data.getString("name");
                                String brand = data.getString("brand");

//                                Toast.makeText(MedicineActivity.this, "Data: " + name + brand, Toast.LENGTH_SHORT).show();
                                medList.add(new MedicineModel(name, brand));
                            }
                        }else{
                            Toast.makeText(MedicineActivity.this, "Response: " + success, Toast.LENGTH_SHORT).show();
                        }

                        medicineAdapter = new MedicineAdapter(MedicineActivity.this, medList);
                        recyclerView.setAdapter(medicineAdapter);

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
