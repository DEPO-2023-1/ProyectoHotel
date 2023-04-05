package Clases;
import java.io.Serializable;
import java.util.ArrayList;

public class Restaurante implements Serializable{

    //atributos clase//
    private ArrayList<Producto> productos;

    //atributos//
    private String menu;
    
    //constructor//
    public Restaurante(String menu, ArrayList<Producto> productos) {
        this.menu = menu;
        this.productos=productos;
    }
    
    //metodos//
    public String getMenu() {
        return menu;
    }
    
    
    public void setMenu(String menu) {
        this.menu = menu;
    }
}
