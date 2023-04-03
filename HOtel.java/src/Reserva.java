import java.util.Date;

public class Reserva {

    // atributos //
    
    private Date fechaInicio;
    private Date fechaFin;

    // constructor //

    public Reserva(Date fechaInicio, Date fechaFin){
        fechaInicio = this.fechaInicio;
        fechaFin = this.fechaFin;
    }

    // metodos //
    
    public Date getFechaInicio(){
        return fechaInicio;
    }

    public Date getFechaFin(){
        return fechaFin;
    }
}
