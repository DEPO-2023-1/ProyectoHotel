package Clases;
import java.util.ArrayList;
import java.util.Date;



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
}
