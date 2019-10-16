package com.persol.tabib.Fragments;


import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.persol.tabib.Adapters.DoctorAdapter;
import com.persol.tabib.Constants;
import com.persol.tabib.DashboardActivity;
import com.persol.tabib.DoctorActivity;
import com.persol.tabib.MedicineActivity;
import com.persol.tabib.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    ImageView doc, med;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        doc = v.findViewById(R.id.doc);
        med = v.findViewById(R.id.pill);

        RecyclerView recyclerView = v.findViewById(R.id.fdocs);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        String[] doctor = {"Ali Yousaf", "Tanveer Hussain", "Abid Bilal", "Shamraiz Ali"};
        recyclerView.setAdapter(new DoctorAdapter(doctor));

        doc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StringRequest request = new StringRequest(Request.Method.GET, Constants.DOC, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        //Toast.makeText(getActivity(), "Response: " + response, Toast.LENGTH_SHORT).show();

                        try {
                            JSONObject res = new JSONObject(response);
                            String success = res.getString("success");

                            //Toast.makeText(getActivity(), "success: " + success, Toast.LENGTH_SHORT).show();
                            if (success.equals("1")){
//                                Toast.makeText(getActivity(), "true", Toast.LENGTH_SHORT).show();
                                JSONArray arr = res.getJSONArray("data");
                                //Toast.makeText(getActivity(), "Data: " + arr, Toast.LENGTH_SHORT).show();
                                for (int i=0;i<arr.length();i++){
                                    JSONObject obj = arr.getJSONObject(i);
                                    //Toast.makeText(getActivity(), "Data: " + obj, Toast.LENGTH_SHORT).show();
                                    String name = obj.getString("name");
                                    String specialty = obj.getString("specialty");

                                    Intent intent = new Intent(getActivity(), DoctorActivity.class);
                                    intent.putExtra("name", name);
                                    intent.putExtra("specialty", specialty);
                                    startActivity(intent);
                                }

                            }else{
                                Toast.makeText(getActivity(), "false", Toast.LENGTH_SHORT).show();

                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getActivity(), "Response: " + error, Toast.LENGTH_SHORT).show();
                    }
                });

                RequestQueue queue = Volley.newRequestQueue(getActivity());
                queue.add(request);

            }
        });

        med.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StringRequest request = new StringRequest(Request.Method.GET, Constants.MED_SRCH, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        //Toast.makeText(getActivity(), "Response: " + response, Toast.LENGTH_SHORT).show();

                        try {
                            JSONObject res = new JSONObject(response);
                            String success = res.getString("success");

                            //Toast.makeText(getActivity(), "success: " + success, Toast.LENGTH_SHORT).show();
                            if (success.equals("1")){
//                                Toast.makeText(getActivity(), "true", Toast.LENGTH_SHORT).show();
                                JSONArray arr = res.getJSONArray("data");
                                //Toast.makeText(getActivity(), "Data: " + arr, Toast.LENGTH_SHORT).show();
                                for (int i=0;i<arr.length();i++){
                                    JSONObject obj = arr.getJSONObject(i);
                                    //Toast.makeText(getActivity(), "Data: " + obj, Toast.LENGTH_SHORT).show();
                                    String name = obj.getString("name");

                                    Intent intent = new Intent(getActivity(), MedicineActivity.class);
                                    intent.putExtra("name", name);
                                    startActivity(intent);
                                }

                            }else{
                                Toast.makeText(getActivity(), "false", Toast.LENGTH_SHORT).show();

                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getActivity(), "Response: " + error, Toast.LENGTH_SHORT).show();
                    }
                });

                RequestQueue queue = Volley.newRequestQueue(getActivity());
                queue.add(request);

            }
        });

        return v;
    }
}
