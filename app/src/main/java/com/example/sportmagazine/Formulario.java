package com.example.sportmagazine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Formulario extends AppCompatActivity {
    Button register;
    EditText nombre;
    EditText apellido;
    EditText correo;
    EditText password;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formulario);

        register = (Button)findViewById(R.id.Registrar);
        nombre = (EditText) findViewById(R.id.nombre);
        apellido = (EditText) findViewById(R.id.apellido);
        correo = (EditText) findViewById(R.id.correo);
        password = (EditText) findViewById(R.id.contraseña);

        register.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {

                        SharedPreferences preferences= getSharedPreferences("Usuario", Context.MODE_PRIVATE);
                        String nom= nombre.getText().toString();
                        String ape= apellido.getText().toString();
                        String cor= correo.getText().toString();
                        String pas= password.getText().toString();

                        Usuario nuevo=new Usuario(nom,ape,cor,pas);

                        SharedPreferences.Editor editor=preferences.edit();

                        editor.putString("nombre",nuevo.getNombre());
                        editor.putString("apeliido",nuevo.getApellido());
                        editor.putString("correo",nuevo.getCorreo());
                        editor.putString("password",nuevo.getPassword());

                        editor.commit();

                        Intent activity2Intent = new Intent(getApplicationContext(), MainActivity.class);

                        startActivity(activity2Intent);



                    }
                });
    }
}
