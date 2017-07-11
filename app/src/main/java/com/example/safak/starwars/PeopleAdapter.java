package com.example.safak.starwars;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by Safak on 11.07.2017.
 */


public class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.ViewHolder>  {

    private List<PeopleInfo> peopleList;

    public PeopleAdapter(List<PeopleInfo> peopleList) {
        this.peopleList = peopleList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int position) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_Item, parent, false);
        ViewHolder holder = new ViewHolder(v);
        holder.nameText.setText(peopleList.get(position).getName());


        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.nameText.setText(peopleList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return peopleList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView nameText;

        public ViewHolder(View itemView) {

            super(itemView);
            nameText=(TextView)itemView.findViewById(R.id.person_name);
        }
    }
}
