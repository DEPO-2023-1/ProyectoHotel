	
import java.util.Date;

public class Temporada {
    
    //atributos//

    private Date fechaIn;
    private Date fechaFin;
    private double aumento;

    //constructor//

    public Temporada (Date fechaIn, Date fechaFin, double aumento){
        fechaIn = this.fechaIn;
        fechaFin = this.fechaFin;
        aumento = this.aumento;
    }

    //metodos//

    public Date getFechaIn(){
        return fechaIn;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public double getAumento(){
        return aumento;
    }
}
