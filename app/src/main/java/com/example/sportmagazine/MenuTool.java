package com.example.sportmagazine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuTool extends AppCompatActivity {


    Button noticias;
    Button gym;
    Button marketPlace;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menutool);
        noticias = (Button)findViewById(R.id.button1);
        gym = (Button)findViewById(R.id.buttonGym);
        marketPlace = findViewById(R.id.sell);


        gym.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activityGym = new Intent(getApplicationContext(),GymActivity.class);
                startActivity(activityGym);
            }
        });

        marketPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activity = new Intent(getApplicationContext(),MarketPlace.class);
                startActivity(activity);
            }
        });
         noticias.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {
                        Intent activity2Intent = new Intent(getApplicationContext(), ListaNoticias.class);
                        startActivity(activity2Intent);
                    }
                });




    }
}
