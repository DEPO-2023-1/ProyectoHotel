public class ConsumoHab {
    
    //atributos//

    private String idHabitacion;
    private String tipo;
    private String servicio;

    //constructor//

    public ConsumoHab(String idHabitacion, String tipo, String servicio){

        idHabitacion = this.idHabitacion;
        tipo = this.tipo;
        servicio = this.servicio;
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
