package com.example.sportmagazine;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import android.widget.BaseAdapter;

import android.view.LayoutInflater;

import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

public class MyAdapterGym extends BaseAdapter {

    Context context;

    ArrayList<Gym> listGym;


    public MyAdapterGym(Context context, ArrayList<Gym> listGym) {
        this.context = context;
        this.listGym = listGym;
    }

    @Override
    public int getCount() {
        return listGym.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        view = LayoutInflater.from(context).inflate(R.layout.item_gym,viewGroup,false);
        TextView nombreGym = view.findViewById(R.id.idNombreGym);
        ImageView photoGym = view.findViewById(R.id.idImageGym);
        TextView plan1 = view.findViewById(R.id.idPlan1);
        TextView plan2 = view.findViewById(R.id.idPlan2);
        TextView plan3 = view.findViewById(R.id.idPlan3);


        nombreGym.setText(listGym.get(position).getNombre());
        photoGym.setImageResource(listGym.get(position).getImageGym());
        plan1.setText(listGym.get(position).getPlan1());
        plan2.setText(listGym.get(position).getPlan2());
        plan3.setText(listGym.get(position).getPlan3());


        return view;
    }


}
