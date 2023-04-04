package Clases;
import java.util.ArrayList;

public class ConsumoHab {
    
    //atributos clases//
    private ArrayList<ConsumoHot> ConsumosHabitacion;
    private ArrayList<Servicio> servicios;

    //atributos//

    private String idHabitacion;
    private String tipo;
    private String servicio;

    //constructor//

    public ConsumoHab(ArrayList<ConsumoHot> ConsumosHabitacion, ArrayList<Servicio> servicios, String idHabitacion, String tipo, String servicio){

        this.idHabitacion = idHabitacion;
        this.tipo = tipo;
        this.servicio = servicio;
        this.ConsumosHabitacion=ConsumosHabitacion;
        this.servicios=servicios;
    }

    //metodos//

    public String getIdHabitacion(){
        return idHabitacion;
    }

    public String getTipo(){
        return tipo;
    }

    public String getServicio(){
        return servicio;
    }

    
}
