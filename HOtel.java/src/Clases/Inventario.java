package Clases;
import java.io.*;
import java.util.ArrayList;

public class Inventario {

    //atributos clase//
    private ArrayList<ConsumoHot> ConsumoInventarios;

    //atributos//
    private File inventario;
    
    //constructor//
    public Inventario(File inventario) {
        this.inventario = inventario;
    }
    
    //metodos//
    public File getInventario() {
        return inventario;
    }

    public void setInventario(File inventario) {
        this.inventario = inventario;
    }
}
