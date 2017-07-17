package com.example.safak.starwars.adapters;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.safak.starwars.R;
import com.example.safak.starwars.pojos.PeopleInfo;
import com.example.safak.starwars.pojos.PlanetsInfo;

import java.util.List;

/**
 * Created by Koray on 14.07.2017.
 */

public class PlanetsInformationAdapter extends RecyclerView.Adapter<PlanetsInformationAdapter.ViewHolder> {

    private List<PlanetsInfo> planetsInfoList;

    public PlanetsInformationAdapter(List<PlanetsInfo> planetsInfoList) {
        this.planetsInfoList = planetsInfoList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int position) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.information_item, parent, false);
        ViewHolder holder = new ViewHolder(v);
        holder.fullNameText.setText(planetsInfoList.get(position).getName());
        holder.darthVaderText.setText(planetsInfoList.get(position).getName());
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.fullNameText.setText(planetsInfoList.get(position).getName());
        holder.darthVaderText.setText(planetsInfoList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return planetsInfoList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView fullNameText;
        TextView darthVaderText;


        public ViewHolder(View itemView) {

            super(itemView);
            fullNameText=(TextView)itemView.findViewById(R.id.name_text);
            darthVaderText=(TextView)itemView.findViewById(R.id.name_value);
        }
    }




}
