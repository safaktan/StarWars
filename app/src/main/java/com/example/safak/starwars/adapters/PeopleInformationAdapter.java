package com.example.safak.starwars.adapters;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.safak.starwars.R;
import com.example.safak.starwars.pojos.PeopleInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Safak on 14.07.2017.
 */

public class PeopleInformationAdapter extends RecyclerView.Adapter<PeopleInformationAdapter.ViewHolder> {

    HashMap<String,String> map;
    String[] keyArray;
    String[] valueArray;
    int i=0;


    public PeopleInformationAdapter(HashMap<String, String> map) {
        this.map = map;
        for (Map.Entry<String, String> entry : map.entrySet()){
            String key = entry.getKey();
            String value = entry.getValue();

            keyArray[i]=key;
            valueArray[i]=value;
            i++;
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int position) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.information_item, parent, false);
        ViewHolder holder = new ViewHolder(v);

        holder.fullNameText.setText(keyArray[position]);
        holder.darthVaderText.setText(valueArray[position]);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.fullNameText.setText(keyArray[position]);
        holder.darthVaderText.setText(valueArray[position]);
    }

    @Override
    public int getItemCount() {
        return valueArray.length;
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
