package com.example.sportmagazine;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class GymActivity  extends AppCompatActivity {

    ListView listView;
    String[] nombre = {"ENERGYM","SPAZIO","PREMIER","GO FITNESS"};

    String[] planEnergym = {"BS 350 / un mes (acceso los 5 dias de la semana", "BS 1800 / trimestre (acceso los 7 dias de la semana"
            ,"BS 5000 / año  (acceso los 7 dias de la semana + 90 dias para congelar + EValuaciones "};

    String[] planSpazio = {"BS 500 / un mes (acceso los 5 dias de la semana", "BS 2000 / trimestre (acceso los 7 dias de la semana"
            ,"BS 6000 / año  (acceso los 7 dias de la semana + 90 dias para congelar + EValuaciones "};

    String[] planPremier = {"BS 200 / un mes (acceso los 5 dias de la semana", "BS 1000 / trimestre (acceso los 7 dias de la semana"
            ,"BS 2600 / año  (acceso los 7 dias de la semana + 90 dias para congelar + EValuaciones "};
    String plan1 = "BS 500 / un mes (acceso los 5 dias de la semana";

    String plan2 = "BS 1300 / trimestre (acceso los 7 dias de la semana";


    String plan3 = "BS 3600 / año  (acceso los 7 dias de la semana + 90 dias para congelar + EValuaciones ";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_gyms);

        ListView listView = findViewById(R.id.ListViewGym) ;

        final ArrayList<Gym> listGyms = new ArrayList<>();


        listGyms.add(new Gym(nombre[0],R.drawable.energym,planEnergym[0],planEnergym[1],planEnergym[2]));
        listGyms.add(new Gym(nombre[1],R.drawable.spazio,planSpazio[0],planSpazio[1],planSpazio[2]));
        listGyms.add(new Gym(nombre[2],R.drawable.premier,planPremier[0],planPremier[1],planPremier[2]));



        MyAdapterGym arrayAdapter =new MyAdapterGym(this ,listGyms);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {



                Intent activity2Intent = new Intent(getApplicationContext(), GymActivity.class);
                activity2Intent.putExtra("gym1", listGyms.get(i).getImageGym());
                activity2Intent.putExtra("gym2",listGyms.get(i).getNombre());
                activity2Intent .putExtra("gym3",listGyms.get(i).getPlan1());
                activity2Intent .putExtra("gym4",listGyms.get(i).getPlan2());
                activity2Intent .putExtra("gym5",listGyms.get(i).getPlan3());
                startActivity(activity2Intent);
            }
        });



    }




}
