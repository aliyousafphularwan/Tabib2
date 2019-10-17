package com.persol.tabib.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.persol.tabib.Misc.MedicineModel;
import com.persol.tabib.R;

import java.util.ArrayList;

public class MedicineAdapter extends RecyclerView.Adapter<MedicineAdapter.MedicineViewHolder> {

    private Context context;
    private ArrayList<MedicineModel> mList;

    public MedicineAdapter(Context context, ArrayList<MedicineModel> mList){

       this.context = context;
        this.mList = mList;

    }

    @NonNull
    @Override
    public MedicineViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.med_recyle_layout, viewGroup, false);
        return new MedicineViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MedicineViewHolder medicineViewHolder, int i) {
        MedicineModel cItem = mList.get(i);

        String name = cItem.getName();
        String brand = cItem.getBrand();

        medicineViewHolder.mName.setText(name);
        medicineViewHolder.mBrand.setText(brand);

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MedicineViewHolder extends RecyclerView.ViewHolder{

        public ImageView mImage;
        public TextView mName, mBrand;

        public MedicineViewHolder(@NonNull View itemView) {
            super(itemView);

            mImage = itemView.findViewById(R.id.med_img);
            mName = itemView.findViewById(R.id.tv_med_name);
            mBrand = itemView.findViewById(R.id.tv_med_brand);

        }
    }

}
