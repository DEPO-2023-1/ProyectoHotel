package Clases;
import java.util.Date;
import java.util.ArrayList;
import java.io.*;



public class Hotel {
	
	private ArrayList<Huesped> huespeds;
	private ArrayList<Grupo> grupos;

    public Hotel(){
        
    }

    public int seleccionarUsuario(String login, String contraseña){
    	return 3;
    }

    public void agregarConsumo(){

    }
    public void agregarPago(){

    }

    public void CrearReserva(){
        int canNinos = Integer.parseInt(input("Ingrese la cantidad de niños que ocuparán camas por favor"));
        int canAdultos = Integer.parseInt(input("Ingrese la cantidad de adultos por favor"));
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

public String input(String mensaje)
	{
		try
		{
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}





}
