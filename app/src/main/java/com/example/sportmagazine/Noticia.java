package com.example.sportmagazine;

public class Noticia {

    String titulo;
    int portada;
    String texto;

    public Noticia(String titulo, int portada, String texto) {
        this.titulo = titulo;
        this.portada = portada;
        this.texto = texto;
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




}
