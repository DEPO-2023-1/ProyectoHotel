package Clases;
<<<<<<< HEAD
import java.util.ArrayList;
=======
import java.io.Serializable;

>>>>>>> a2c23bf7ce9b84389d56b8517ea5933eec7de3f8

public class ConsumoHab {
    


    //atributos//

    private String idHabitacion;
    private String tipo;
    private String servicio;

    //constructor//

    public ConsumoHab(String idHabitacion, String tipo, String servicio){

        this.idHabitacion = idHabitacion;
        this.tipo = tipo;
        this.servicio = servicio;


    }

    //metodos//

    public String getIdHabitacion(){
        return idHabitacion;
    }


    public String getServicio(){
        return servicio;
    }

<<<<<<< HEAD
    public ArrayList<Servicio> getServicios(){
        return servicios;
=======
    public String getTipo(){
        return tipo;
>>>>>>> a2c23bf7ce9b84389d56b8517ea5933eec7de3f8
    }
    
}
