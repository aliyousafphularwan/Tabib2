package com.persol.tabib.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.persol.tabib.R;

public class DoctorAdapter extends RecyclerView.Adapter<DoctorAdapter.DoctorViewHolder> {

    String[] data;

    public DoctorAdapter(String[] data){

        this.data = data;

    }

    @NonNull
    @Override
    public DoctorAdapter.DoctorViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.recyclerview_layout, viewGroup, false);

        return new DoctorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DoctorAdapter.DoctorViewHolder doctorViewHolder, int i) {

        String name = data[i];
        doctorViewHolder.dName.setText(name);

    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class DoctorViewHolder extends RecyclerView.ViewHolder {

        ImageView dFoto;
        TextView dName;
        TextView dType;
        TextView dDegree;
        TextView dFee;

        public DoctorViewHolder(@NonNull View itemView) {
            super(itemView);

            dFoto = itemView.findViewById(R.id.rv_foto);
            dName = itemView.findViewById(R.id.rv_dname);
            dType = itemView.findViewById(R.id.rv_dtype);
            dDegree = itemView.findViewById(R.id.rv_ddegree);
            dFee = itemView.findViewById(R.id.rv_dfee);

        }
    }
}
