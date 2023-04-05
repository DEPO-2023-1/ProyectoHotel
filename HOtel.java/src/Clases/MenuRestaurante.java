package Clases;

public abstract class MenuRestaurante {

	private String nombre;
	private float precio;
	private String horaInicio;
	private String horaFinal;
	
	
	public MenuRestaurante(String nombre, float precio, String horaInicio, String horaFinal) {
		this.nombre = nombre;
		this.precio = precio;
		this.horaInicio = horaInicio;
		this.horaFinal = horaFinal;
		
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public float getPrecio() {
		return precio;
	}


	public void setPrecio(float precio) {
		this.precio = precio;
	}


	public String getHoraInicio() {
		return horaInicio;
	}


	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}


	public String getHoraFinal() {
		return horaFinal;
	}


	public void setHoraFinal(String horaFinal) {
		this.horaFinal = horaFinal;
	}
	
	
	
}
