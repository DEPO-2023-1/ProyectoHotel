package Clases;
import java.util.Date;
import java.util.ArrayList;
import java.io.*;



public class Hotel {
	
	private ArrayList<Huesped> huespeds;
	private ArrayList<Grupo> grupos;
    private ArrayList<Servicio> servicios;
    private ArrayList<ConsumoHot> consumosHotel;
    private ArrayList<Habitacion> habitaciones;
    private ArrayList<Usuario> usuarios;
    private Inventario inventario;

    public Hotel(){
        
    }

    public int seleccionarUsuario(String login, String contraseña){
    	return 3;
    }

    public void agregarConsumo(){

    }
    public void agregarPago(){

    }

    public void crearReserva(){
    	
    	int inicialAnio = Integer.parseInt(input("Ingrese el año del dia de inicio del reserva"));
        int inicialMes = Integer.parseInt(input("Ingrese el mes de día del inicio de reserva"));
        int inicialDia = Integer.parseInt(input("Ingrese el día del inicio de reserva"));
        int finalAnio = Integer.parseInt(input("Ingrese el año del dia del final de reserva"));
        int finalMes = Integer.parseInt(input("Ingrese el mes de día del final de reserva"));
        int finalDia = Integer.parseInt(input("Ingrese el día del final de reserva"));
        
        @SuppressWarnings("deprecation")
		Date inicialDate = new Date(inicialAnio, inicialMes, inicialDia);
        @SuppressWarnings("deprecation")
		Date finalDate = new Date(finalAnio, finalMes, finalDia);
    	
        String disponible = reservaDisponible(inicialDate, finalDate);
        if (disponible == "") {
        	System.out.println("lo siento no hay cupos disponibles");
        }
        else {
        	ArrayList<Huesped> huespedList = new ArrayList<Huesped>();
        	boolean centinela = true;
        	while(centinela) {
        		Huesped huesped = agregarHuesped();
        		huespedList.add(huesped);
        		
        		System.out.println("Ingrese una opcion");
        		System.out.println("1- Agregar otro huesped");
        		System.out.println("2- Terminar proceso");
        		int nuevo = Integer.parseInt(input(""));
        		if (nuevo == 2) {
        			centinela = false;
        		}
        	}
        	Grupo grupo = agregarGrupo(huespedList, disponible);
	        
	        agregarReserva(grupo, inicialDate, finalDate, disponible);
	        
        }
    }

    private String reservaDisponible(Date inicialDate, Date finalDate){
    	String respuesta = "";
    	
    	int canNinos = Integer.parseInt(input("Ingrese la cantidad de niños que ocuparán camas por favor"));
        int canAdultos = Integer.parseInt(input("Ingrese la cantidad de adultos por favor"));
        
        for (Habitacion h: habitaciones) {
			int maxNinos = h.getCapacidadNino();
			int maxAdultos = h.getCapaciodadAdulto();
			boolean disponible = h.disponibleEnFecha(inicialDate, finalDate);
			
			if (disponible && maxNinos >= canNinos && maxAdultos >= canAdultos) {
				respuesta = h.getIdHabitacion();
				break;
			}
		}
        
        return respuesta;
    }

    private Huesped agregarHuesped(){
    	System.out.println("Por favor ingrese sus datos\n\n\n");
		String nombre = input("Ingrese su nombre");
		int cedula = Integer.parseInt(input("Ingrese su cedula"));
		int edad = Integer.parseInt(input("Ingrese su edad"));
		String correo = input("Ingrese su correo, si no tiene ingrese enter");
		
		Huesped huesped = new Huesped(nombre, cedula, correo, edad);
    	 
    	return huesped;
    		
    }

    private Grupo agregarGrupo(ArrayList<Huesped> huespedes, String IDHabitacion){
    	Grupo grupo = new Grupo(IDHabitacion, huespedes);
    	return grupo;
    }

    private void agregarReserva(Grupo grupo, Date inicialDate, Date finalDate, String IDHabitacion){
    	
    	for (Habitacion h: habitaciones) {
    		String nomHabitacion = h.getIdHabitacion();
    		if (nomHabitacion == IDHabitacion) {
    			h.addGrupo(grupo);
    			h.addReserva(inicialDate, finalDate);
    		}
    	}
    	
    }

    public void cancelarReserva(){

    }

    public String checkOut(){
    	return "hola";
    }

    public void cargarHotel(){
        System.out.println("hola");
    }

    public void cargarHotelManual(){

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
