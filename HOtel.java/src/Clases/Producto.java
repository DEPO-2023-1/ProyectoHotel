package Clases;

import java.io.Serializable;

public class Producto implements Serializable{

    //atributos//
    private String nombre;
    private double precio;
    
    //constructor//
    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
    
    //metodos//
    public String getNombre() {
        return nombre;
    }
    
    public double getPrecio() {
        return precio;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
