package Clases;
public class Servicio {

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
