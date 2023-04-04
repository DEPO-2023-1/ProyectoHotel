package Clases;
import java.util.ArrayList;



public class Grupo {

    //atributos clase//
    private ArrayList<Huesped> huespedes;
    private String IDHabitacion;
    
    //constructor//
    public Grupo(String IDHabitacion) {
        this.IDHabitacion = IDHabitacion;
        this.huespedes = new ArrayList<Huesped>();
    }
    
    // metodos//
    
    public void addHuesped(String nombre, int cedula, int edad, String correo) {
    	Huesped huesped = new Huesped(nombre, cedula, correo, edad);
    	huespedes.add(huesped);
    }
    
    
    public String getIDHabitacion() {
        return IDHabitacion;
    }
    
    public void setIDHabitacion(String IDHabitacion) {
        this.IDHabitacion = IDHabitacion;
    }
    
    public ArrayList<Huesped> getGrupo() {
        return huespedes;
    }
    
    public void setGrupo(ArrayList<Huesped> grupo) {
        this.huespedes = grupo;
    }
}
