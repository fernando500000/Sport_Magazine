package com.example.sportmagazine;

public class Gym {


 String nombre ;
 int imageGym;
 String plan1;
     String plan2;
    String plan3;


    public Gym(String nombre, int imageGym, String plan1, String plan2, String plan3) {
        this.nombre = nombre;
        this.imageGym = imageGym;
        this.plan1 = plan1;
        this.plan2 = plan2;
        this.plan3 = plan3;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getImageGym() {
        return imageGym;
    }

    public void setImageGym(int imageGym) {
        this.imageGym = imageGym;
    }

    public String getPlan1() {
        return plan1;
    }

    public void setPlan1(String plan1) {
        this.plan1 = plan1;
    }

    public String getPlan2() {
        return plan2;
    }

    public void setPlan2(String plan2) {
        this.plan2 = plan2;
    }

    public String getPlan3() {
        return plan3;
    }

    public void setPlan3(String plan3) {
        this.plan3 = plan3;
    }
}
