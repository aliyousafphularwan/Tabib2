package com.persol.tabib.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.persol.tabib.Misc.DoctorModel;
import com.persol.tabib.Misc.MedicineModel;
import com.persol.tabib.R;

import java.util.ArrayList;

public class DocAdapter extends RecyclerView.Adapter<DocAdapter.DocViewHolder> {

    private Context context;
    private ArrayList<DoctorModel> dList;

    public DocAdapter(Context context, ArrayList<DoctorModel> dList){

        this.context = context;
        this.dList = dList;

    }

    @NonNull
    @Override
    public DocAdapter.DocViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.doc_recycler_layout, viewGroup, false);

        return new DocViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DocViewHolder docViewHolder, int i) {
        DoctorModel cItem = dList.get(i);

        String name = cItem.getDname();
        String degree = cItem.getDegree();

        docViewHolder.name.setText(name);
        docViewHolder.degree.setText(degree);

    }

    @Override
    public int getItemCount() {
        return dList.size();
    }

    public class DocViewHolder extends RecyclerView.ViewHolder {

        TextView name, degree;

        public DocViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.doc_name);
            degree = itemView.findViewById(R.id.doc_degree);

        }
    }
}
