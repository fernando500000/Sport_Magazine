package com.example.sportmagazine;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ItemGym extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_gym);

        Bundle extras = getIntent().getExtras();
        int imagen = extras.getInt("gym1");
        String nombreGym = extras.getString("gym2");
        String plan1 = extras.getString("gym3");
        String plan2 = extras.getString("gym4");
        String plan3 = extras.getString("gym5");

        ImageView portada = (ImageView) findViewById(R.id.idImageGym);
        TextView nombre = (TextView) findViewById(R.id.idNombreGym);
        TextView p1 = (TextView) findViewById(R.id.idPlan1);
        TextView p2 = (TextView) findViewById(R.id.idPlan2);
        TextView p3 = (TextView) findViewById(R.id.idPlan3);


        portada.setImageResource(imagen);
        nombre.setText(nombreGym);
        p1.setText(plan1);
        p2.setText(plan2);
        p3.setText(plan3);

    }}
