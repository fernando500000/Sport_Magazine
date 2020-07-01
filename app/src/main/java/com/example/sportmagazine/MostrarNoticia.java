package com.example.sportmagazine;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sportmagazine.repository.local.NoticiaRepository;

public class MostrarNoticia extends AppCompatActivity {


    private Noticia noticia;
    int imagen;
    String texto1;
    String titulo;
    boolean le;
    private Noticia taskSelected;
    private NoticiaRepository noticiaRepository;
    private String shareNot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrarnoticia);
        noticiaRepository = new NoticiaRepository(getApplication());

        final TextView texto = findViewById(R.id.futbol);
        final TextView ti = findViewById(R.id.titulo1);
        final Button bo = findViewById(R.id.leer);
        final ImageView portada = (ImageView) findViewById(R.id.portada1);
        Intent intent = getIntent();
        if (intent.hasExtra("id")) {
            int id = intent.getIntExtra("id", 0);
            noticiaRepository.getById(id).observe(this, new Observer<Noticia>() {
                @Override
                public void onChanged(Noticia task) {
                    noticia = task;
                    taskSelected = task;
                    portada.setImageResource(task.getPortada());
                    ti.setText(task.getTitulo());
                    shareNot =taskSelected.getTexto();
                    texto.setText(task.getTexto());

                    if (task.isRead()) {
                        bo.setText("Noticia leida");
                    } else {
                        bo.setText("Noticia no leida");
                    }
                }
            });


            bo.setOnClickListener(
                    new View.OnClickListener() {
                        public void onClick(View view) {
                            taskSelected.setRead(!taskSelected.isRead());
                            noticiaRepository.updateEntry(taskSelected);
                            Intent activity2Intent = new Intent(getApplicationContext(), ListaNoticias.class);

                            startActivity(activity2Intent);
                        }
                    });
        }
    }

    public void shareNotice(View view) {

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, "Hey! te comparto esta noticia  "+shareNot );
        intent.setType("text/plain");
        startActivity(intent);


    }
}