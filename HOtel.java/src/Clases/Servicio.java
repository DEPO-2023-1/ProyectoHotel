package Clases;
import java.util.ArrayList;

public class Servicio {

    //atributos clases//
    private ArrayList<Otro> otros;
    private Restaurante restaurante;

    //atributos//
    private double precioConsumo;
    
    //constructor//
    public Servicio(double precioConsumo) {
        this.precioConsumo = precioConsumo;
    }
    
    //metodos//
    public double getPrecioConsumo() {
        return precioConsumo;
    }
    
    public void setPrecioConsumo(double precioConsumo) {
        this.precioConsumo = precioConsumo;
    }

}
