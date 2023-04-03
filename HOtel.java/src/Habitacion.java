public class Habitacion {
    
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

    //metodos//

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
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
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
	public void setBalcon(Boolean balcon) {
		this.balcon = balcon;
	}
	public Boolean getCocina() {
		return cocina;
	}
	public void setCocina(Boolean cocina) {
		this.cocina = cocina;
	}
	public Boolean getVista() {
		return vista;
	}
	public void setVista(Boolean vista) {
		this.vista = vista;
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
	public void setPrecioF(double precioF) {
		this.precioF = precioF;
	}
}
