package Clases;
import java.io.Serializable;
import java.util.ArrayList;

public class Factura implements Serializable{
    //atributos clase//
    private ArrayList<ConsumoHab> consumos;
    private ArrayList<ConsumoHot> ConsumosTotales;
    private ArrayList<Servicio> servicios;

    //atributos//
    private double precio;

    //constructor//
    public Factura(ArrayList<ConsumoHot> ConsumosTotales,ArrayList<Servicio> servicios, ArrayList <ConsumoHab> consumos, double precio){
        this.consumos=consumos;
        this.ConsumosTotales=ConsumosTotales;
        this.servicios=servicios;
        this.precio=precio;
    }

    //metodos//
    public double getPrecio() {
        return precio;
    }
}
