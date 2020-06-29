package com.example.sportmagazine;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MostrarNoticia extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrarnoticia);

        Bundle extras = getIntent().getExtras();
        int imagen= extras.getInt("ID_EXTRA1");
        String texto1= extras.getString("ID_EXTRA3");
        String titulo= extras.getString("ID_EXTRA2");

        TextView texto=  findViewById(R.id.futbol);
        TextView ti= findViewById(R.id.titulo1);
        ImageView portada= (ImageView) findViewById(R.id.portada1);
        ti.setText(titulo);
        texto.setText(texto1);
        portada.setImageResource(imagen);
    }
}
