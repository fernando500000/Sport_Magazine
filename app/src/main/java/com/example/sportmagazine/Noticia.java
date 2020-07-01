package com.example.sportmagazine;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity(tableName ="noticia")
public class Noticia {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo (name= "id")
    int id;
    @ColumnInfo (name= "titulo")
    String titulo;
    @ColumnInfo (name= "portada")
    int portada;
    @ColumnInfo (name= "texto")
    String texto;
    @ColumnInfo (name= "read")
     boolean read ;



    public Noticia( String titulo, int portada, String texto , boolean read ) {
        this.titulo = titulo;
        this.portada = portada;
        this.texto = texto;
        this.read=read;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getPortada() {
        return portada;
    }

    public void setPortada(int portada) {
        this.portada = portada;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
