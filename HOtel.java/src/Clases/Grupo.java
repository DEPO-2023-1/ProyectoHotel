package Clases;
import java.util.ArrayList;



public class Grupo {

    //atributos clase//
    private ArrayList<Huesped> huespedes;

    //atributos//
    private String IDHabitacion;
    private ArrayList<String> grupo;
    
    //constructor//
    public Grupo(String IDHabitacion, ArrayList<String> grupo, ArrayList<Huesped> huespedes) {
        this.IDHabitacion = IDHabitacion;
        this.grupo = grupo;
        this.huespedes=huespedes;
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
