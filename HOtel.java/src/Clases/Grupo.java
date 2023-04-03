package Clases;
import java.util.ArrayList;



public class Grupo {

    //atributos//
    private String IDHabitacion;
    private ArrayList<String> grupo;
    
    //constructor//
    public Grupo(String IDHabitacion, ArrayList<String> grupo) {
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
    
    public ArrayList<String> getGrupo() {
        return grupo;
    }
    
    public void setGrupo(ArrayList<String> grupo) {
        this.grupo = grupo;
    }
}
