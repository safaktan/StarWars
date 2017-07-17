package com.example.safak.starwars.adapters;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.safak.starwars.R;
import com.example.safak.starwars.pojos.PeopleInfo;

import java.util.List;

/**
 * Created by Safak on 14.07.2017.
 */

public class PeopleInformationAdapter extends RecyclerView.Adapter<PeopleInformationAdapter.ViewHolder> {

    private List<PeopleInfo> peopleInfoList;

    public PeopleInformationAdapter(List<PeopleInfo> peopleInfoList) {
        this.peopleInfoList = peopleInfoList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int position) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.information_item, parent, false);
        ViewHolder holder = new ViewHolder(v);
        holder.fullNameText.setText(peopleInfoList.get(position).getName());
        holder.darthVaderText.setText(peopleInfoList.get(position).getName());
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.fullNameText.setText(peopleInfoList.get(position).getName());
        holder.darthVaderText.setText(peopleInfoList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return peopleInfoList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView fullNameText;
        TextView darthVaderText;


        public ViewHolder(View itemView) {

            super(itemView);
            fullNameText=(TextView)itemView.findViewById(R.id.tv_label);
            darthVaderText=(TextView)itemView.findViewById(R.id.tv_value);
        }
    }




}
