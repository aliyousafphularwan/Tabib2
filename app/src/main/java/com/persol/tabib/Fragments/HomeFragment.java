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
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.persol.tabib.Adapters.DoctorAdapter;
import com.persol.tabib.Constants;
import com.persol.tabib.DashboardActivity;
import com.persol.tabib.DoctorActivity;
import com.persol.tabib.R;

import org.json.JSONException;
import org.json.JSONObject;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    ImageView doc;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        doc = v.findViewById(R.id.nurse);
        doc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StringRequest request = new StringRequest(Request.Method.GET, Constants.DOC, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jo = new JSONObject(response);
                            String success = jo.getString("success");

                            if (success.equals(1)){

                                Toast.makeText(getActivity(), "Response: " + success, Toast.LENGTH_SHORT).show();

                            }else{

                                Toast.makeText(getActivity(), "Response: " + success, Toast.LENGTH_SHORT).show();

                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

            }
        });

        RecyclerView recyclerView = v.findViewById(R.id.fdocs);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        String[] doctor = {"Ali Yousaf", "Tanveer Hussain", "Abid Bilal", "Shamraiz Ali"};
        recyclerView.setAdapter(new DoctorAdapter(doctor));

        return v;
    }

}
