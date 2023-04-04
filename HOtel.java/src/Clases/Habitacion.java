package Clases;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;



public abstract class Habitacion {
    
	//atributos clases//
	private ArrayList<Temporada> temporadas;
	private ArrayList<Reserva> reservas;
	private ArrayList<Grupo> grupos;
	private Factura factura;


	//atributos//
	
	private String idHabitacion;
	private Boolean disponible;
	private String ubicacion;
	private int capacidadNino;
	private int capaciodadAdulto;
	private Boolean balcon;
	private Boolean cocina;
	private Boolean vista;
	private double precioI;
	private double precioF;

	//constructor//
	public Habitacion(Factura factura, String idHabitacion, Boolean disponible, String ubicacion, int capacidadNino, int capaciodadAdulto,
	Boolean balcon, Boolean cocina, Boolean vista, double precioI, double precioF){
		this.temporadas = new ArrayList<Temporada>();
		this.reservas = new ArrayList<Reserva>();;
		this.grupos = new ArrayList<Grupo>();;
		this.factura=factura;
		this.idHabitacion=idHabitacion;
		this.disponible=disponible;
		this.ubicacion=ubicacion;
		this.capacidadNino=capacidadNino;
		this.capaciodadAdulto=capaciodadAdulto;
		this.balcon=balcon;
		this.cocina=cocina;
		this.vista=vista;
		this.precioI=precioI;
		this.precioF=precioF;
	}

    //metodos//
	
	public boolean disponibleEnFecha(Date inicialDate, Date finalDate) {
		
		boolean respuesta = true;
		for (Reserva r: reservas) {
			Date reservaInicio = r.getFechaInicio();
			Date reservaFinal = r.getFechaFin();
			if ((inicialDate.before(reservaInicio)&&finalDate.after(reservaInicio))||(inicialDate.before(reservaFinal)&&finalDate.after(reservaFinal))) {
				respuesta = false;
				break;
			}
		}
		return respuesta;
	}
	
	
	public void addTemporada(Date inicialDate, Date finalDate, double aumento) {
		
		Temporada temporada = new Temporada(inicialDate, finalDate, aumento);
		temporadas.add(temporada);
		
	}
	
	public void addReserva(Date inicialDate, Date finalDate) {
		Reserva reserva = new Reserva(inicialDate, finalDate);
		reservas.add(reserva);
	}
	
	public void addGrupo(Grupo grupo) {
		grupos.add(grupo);
	}
	
    public String getIdHabitacion() {
		return idHabitacion;
	}
	public void setIdHabitacion(String idHabitacion) {
		this.idHabitacion = idHabitacion;
	}
	public Boolean getDisponible() {
		return disponible;
	}
	public void setDisponible(Boolean disponible) {
		this.disponible = disponible;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public int getCapacidadNino() {
		return capacidadNino;
	}
	public void setCapacidadNino(int capacidadNino) {
		this.capacidadNino = capacidadNino;
	}
	public int getCapaciodadAdulto() {
		return capaciodadAdulto;
	}
	public void setCapaciodadAdulto(int capaciodadAdulto) {
		this.capaciodadAdulto = capaciodadAdulto;
	}
	public Boolean getBalcon() {
		return balcon;
	}
	public Boolean getCocina() {
		return cocina;
	}
	public Boolean getVista() {
		return vista;
	}
	public double getPrecioI() {
		return precioI;
	}
	public void setPrecioI(double precioI) {
		this.precioI = precioI;
	}
	public double getPrecioF() {
		return precioF;
	}

	public double calcularPrecioIntermedio(int capacidadNino, int capaciodadAdulto, Boolean balcon, Boolean cocina,
	Boolean vista, double precioI){

		double intermedio = precioI;
		if (capacidadNino >2){
			intermedio = intermedio + precioI*0.05;
		}
		if(capaciodadAdulto > 2){
			intermedio = intermedio + precioI*0.05;
		}
		if(balcon){
			intermedio = intermedio + precioI*0.05;
		}
		if(cocina){
			intermedio = intermedio + precioI*0.05;
		}
		if(vista){
			intermedio = intermedio + precioI*0.05;
		}
		return intermedio;
	}

	public int dayofWeek(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.DAY_OF_WEEK);
	}

	public void calcularPrecioTotal(double precioIntermedio, Date inicialDate, Date finalDate, ArrayList<Temporada> temporadas){
		double aumento = 0;
		double aumento1 = 0;
		double aumento2 = 0;

		if(dayofWeek(inicialDate)==6 && dayofWeek(finalDate)==7){
			precioIntermedio = precioIntermedio + 0.05*precioIntermedio;
		}
		else{
			for(Temporada t: temporadas) {
				Date fechaInicio = t.getFechaIn();
				Date fechaFinal = t.getFechaFin();
				if(inicialDate.after(fechaInicio) && inicialDate.before(fechaFinal)){
					aumento1 = t.getAumento();
				}
				if(finalDate.after(fechaInicio) && inicialDate.before(fechaFinal)){
					aumento2=t.getAumento();
				}
	
			}
	
			if(aumento1 > aumento2){
				aumento = aumento2;
	
			}else{
				aumento = aumento1;
			}
			
		}
		this.precioF= precioIntermedio + aumento;
	}
}
