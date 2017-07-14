package com.example.safak.starwars;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.safak.starwars.pojos.PlanetsInfo;

import java.util.List;

/**
 * Created by Koray on 11.07.2017.
 */

public class PlanetsAdapter extends RecyclerView.Adapter<PlanetsAdapter.ViewHolder>  {

    private List<PlanetsInfo> planetsList;

    public PlanetsAdapter(List<PlanetsInfo> planetsList) {
        this.planetsList = planetsList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int position) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_item, parent, false);
        ViewHolder holder = new ViewHolder(v);
        holder.nameText.setText(planetsList.get(position).getName());
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.nameText.setText(planetsList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return planetsList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView nameText;

        public ViewHolder(View itemView) {

            super(itemView);
            nameText=(TextView)itemView.findViewById(R.id.person_name);
        }

        @Override
        public void onClick(View v) {

        }
    }
}