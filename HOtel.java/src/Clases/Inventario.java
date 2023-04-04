package Clases;
import java.io.*;
import java.util.ArrayList;

public class Inventario {

    //atributos clase//
    private ArrayList<ConsumoHot> consumoInventarios;

    //atributos//
    private File inventario;
    
    //constructor//
    public Inventario(File inventario, ArrayList<ConsumoHot> consumoInventarios) {
        this.inventario = inventario;
        this.consumoInventarios = consumoInventarios;
    }
    
    //metodos//
    public File getInventario() {
        return inventario;
    }

    public void setInventario(File inventario) {
        this.inventario = inventario;
    }
}
