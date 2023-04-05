package Clases;

import java.io.Serializable;

public class Otro implements Serializable{
    

    //atributos//
    private String nombre;
    private double precio;

    //constructor//
    public Otro (String nombre, double precio){
        this.nombre = nombre;
        this.precio = precio;
    }
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String Nombre) {
        this.nombre = Nombre;
    }
    
    public double getPrecio() {
        return precio;
    }
    
    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
