package com.example.sportmagazine;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    Context context;
    ArrayList<Noticia> arr;

    public CustomAdapter(Context context, ArrayList<Noticia> arr) {
        this.context = context;
        this.arr = arr;
    }

    @Override
    public int getCount() {
        return arr.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view = LayoutInflater.from(context).inflate(R.layout.activity_tienda,viewGroup,false);
        TextView titulo= view.findViewById(R.id.titulo);
        ImageView portada= view.findViewById(R.id.portada);

        titulo.setText(arr.get(i).getTitulo());
        portada.setImageResource(arr.get(i).getPortada());

        return view;
    }

}
