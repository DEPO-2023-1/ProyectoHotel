package Clases;
import java.util.ArrayList;



public class Grupo {

    //atributos clase//
    private ArrayList<Huesped> grupo;
    private String IDHabitacion;
    
    //constructor//
    public Grupo(String IDHabitacion, ArrayList<Huesped> grupo) {
        this.IDHabitacion = IDHabitacion;
        this.grupo = grupo;
    }
    
    // metodos//
    public String getIDHabitacion() {
        return IDHabitacion;
    }
    
    public void setIDHabitacion(String IDHabitacion) {
        this.IDHabitacion = IDHabitacion;
    }
    
    public ArrayList<Huesped> getGrupo() {
        return grupo;
    }
    
    public void setGrupo(ArrayList<Huesped> grupo) {
        this.grupo = grupo;
    }
}
