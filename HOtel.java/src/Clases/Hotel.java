package Clases;
import java.util.Date;
import java.util.ArrayList;
import java.io.*;



public class Hotel {
	
	private ArrayList<Huesped> huespeds;
	private ArrayList<Grupo> grupos;
    private String hola;


    public Hotel(){
        this.hola = "casa";
        String nuevo = hola;
    }

    public int seleccionarUsuario(String login, String contraseña){
    	return 3;
    }

    public void agregarConsumo(){

    }
    public void agregarPago(){

    }

    public void CrearReserva(){

    }

    private Boolean reservaDisponible(){
    	return true;
    }
/*
    private Huesped agregarHuesped(){
    	
    }

    private Grupo agregarGrupo(ArrayList<Huesped> huespedes){

    }
*/
    private void agregarReserva(Grupo grupo, Date iniclaDate, Date finalDate, String tipoHabitacion){

    }

    public void cancelarReserva(){

    }

    public String checkOut(){
    	return "hola";
    }

    public void CargarHotel(){

    }

    public void CargarHotelManual(){

    }

    public void actualizarInformacion(){

    }

    private  void cargarInformacionArchivo(File habitaciones, File archivoUsuario, File inventario, File servicio, File menuComedor, File menuCuarto){

    }

    private void cargarHabitacion(File habitaciones){

    }
    
  

    private void cargarUsuarios(File archivoUsuario){

    }

    private void cargarInventario(File inventario){

    }
    
    private void cargarServicio(File Servicio){

    }
    
    private void cargarMenuComedor(File menuComedor){

    }

    private void cargarMenuCuarto(File menuCuarto){
        
    }







}
