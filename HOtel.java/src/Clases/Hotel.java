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
    private ArrayList<Inventario> inventarios;

    public Hotel(){
    	this.grupos = new ArrayList<Grupo>();
    	this.huespeds = new ArrayList<Huesped>();
    	this.servicios = new ArrayList<Servicio>();
    	this.consumosHotel = new ArrayList<ConsumoHot>();
    	this.habitaciones = new ArrayList<Habitacion>();
    	this.inventarios = new ArrayList<Inventario>();
    	
    }

    public int seleccionarUsuario(String login, String contraseña){
    	return 3;
    }

    public void agregarConsumo(){
    	
    	String IDHabitacion = input("Ingrese la habitacion");
    	String servicio = input("Ingrese el servcio consumido");
    	
    	for (Habitacion h: habitaciones) {
			String nombre = h.getIdHabitacion();
			if (nombre == IDHabitacion) {
				h.agregarConsumo(IDHabitacion, servicio);
				break;
			}
    	}
    	
    	
    }
    public void agregarPago(){
    	
    	String IDHabitacion = input("Ingrese la habitacion");
    	String servicio = input("Ingrese el servcio consumido");
    	
    	for (Habitacion h: habitaciones) {
			String nombre = h.getIdHabitacion();
			if (nombre == IDHabitacion) {
				h.agregarPago(IDHabitacion, servicio);
				break;
			}
    	}
    	
    }
    
    public void factura() {
    	
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
    	
        String IDHabitacion = reservaDisponible(inicialDate, finalDate);
        if (IDHabitacion == "") {
        	System.out.println("lo siento no hay cupos disponibles");
        }
        else {
        	Grupo grupo = new Grupo(IDHabitacion);
        	boolean centinela = true;
        	while(centinela) {
        		agregarHuespedGrupo(grupo);
        		System.out.println("Ingrese una opcion");
        		System.out.println("1- Agregar otro huesped");
        		System.out.println("2- Terminar proceso");
        		int nuevo = Integer.parseInt(input(""));
        		if (nuevo == 2) {
        			centinela = false;
        		}
        	}
	        grupos.add(grupo);
	        agregarReserva(grupo, inicialDate, finalDate, IDHabitacion);
	        
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

    private void agregarHuespedGrupo(Grupo grupo){
    	System.out.println("Por favor ingrese sus datos\n\n\n");
		String nombre = input("Ingrese su nombre");
		int cedula = Integer.parseInt(input("Ingrese su cedula"));
		int edad = Integer.parseInt(input("Ingrese su edad"));
		String correo = input("Ingrese su correo, si no tiene ingrese enter");
		
		grupo.addHuesped(nombre, cedula, edad, correo);
		
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

    public void cargarHotel() throws IOException{
    	
    	String Habitaciones = input("Ingrese la ruta de archivo con la informacion de las habitaciones");
    	String Usuario = input("Ingrese la ruta de archivo con la informacion de los usuarios");
    	String inventario = input("Ingrese la ruta de archivo con la informacion del inventario");
    	String Servicio = input("Ingrese la ruta de archivo con la informacion de los servicios");
    	String menuComedor = input("Ingrese la ruta de archivo con la informacion del menu del comedor");
    	String menuCuarto = input("Ingrese la ruta de archivo con la informacion del menu del servicio al cuarto");
    	String temporada = input("Ingrese la ruta de archivo con la informacion de las temporada");
    	
    	cargarHabitacion(Habitaciones);
    	cargarUsuarios(Usuario);
    	cargarInventario(inventario);
    	cargarServicio(Servicio);
    	cargarMenuComedor(menuComedor);
    	cargarMenuCuarto(menuCuarto);
    	cargarTemporada(temporada);
    	
    }

    public void cargarHotelManual(){

    }

    public void actualizarInformacion(){

    }

    private void cargarHabitacion(String habitaciones) throws IOException{
    	
    	File archivo = new File(habitaciones);
		BufferedReader lector = new BufferedReader(new FileReader(archivo));
		String linea = lector.readLine();
		while(linea!=null) {

			String [] datos = linea.split(";");
			
			String idHabitacion = datos[0];
			String tipo = datos[1];
			String ubicacion = datos[2];
			int capacidadNino = Integer.parseInt(datos[3]);
			int capaciodadAdulto = Integer.parseInt(datos[4]);
			Boolean balcon = Boolean.parseBoolean(datos[5]);
			Boolean cocina = Boolean.parseBoolean(datos[6]);
			Boolean vista = Boolean.parseBoolean(datos[7]);
			float PrecioI = Float.parseFloat(datos[8]);
			
			if (tipo == "Standar") {
				Standard habitacion = new Standard(idHabitacion, tipo, ubicacion, capacidadNino,
						capaciodadAdulto, balcon, cocina, vista, PrecioI);
				habitaciones.add(habitacion);
				
			}
			else if (tipo == "Suite") {
				Suite habitacion = new Suite(idHabitacion, tipo, ubicacion, capacidadNino,
						capaciodadAdulto, balcon, cocina, vista, PrecioI);
				habitaciones.add(habitacion);
				
			}
			else if (tipo == "SuitDoble") {
				SuitDoble habitacion = new SuitDoble(idHabitacion, tipo, ubicacion, capacidadNino,
						capaciodadAdulto, balcon, cocina, vista, PrecioI);
				habitaciones.add(habitacion);
			}
			
			linea = lector.readLine();
		}
		lector.close();
	}

    private void cargarUsuarios(String Usuario) throws IOException{
    	
    	File archivo = new File(Usuario);
		BufferedReader lector = new BufferedReader(new FileReader(archivo));
		String linea = lector.readLine();
		while(linea!=null) {

			String [] datos = linea.split(";");
			
			String tipo = datos[0];
			String login = datos[1];
			String contrasena = datos[2];
			
			
			if (tipo == "Administrador") {
				Administrador usuario = new Administrador(contrasena, login);
				usuarios.add(usuario);
				
			}
			if (tipo == "Recepcionista") {
				Recepcionista usuario = new Recepcionista(contrasena, login);
				usuarios.add(usuario);
				
			}
			if (tipo == "Empleado") {
				Empleado usuario = new Empleado(contrasena, login);
				usuarios.add(usuario);
			}
			
			linea = lector.readLine();
		}
		lector.close();
	}
    	
    	

    private void cargarInventario(String inventario) throws IOException{
    	
    	File archivo = new File(inventario);
		BufferedReader lector = new BufferedReader(new FileReader(archivo));
		String linea = lector.readLine();
		while(linea!=null) {

			String [] datos = linea.split(";");
			
			String producto = datos[0];
			int cantidad = Integer.parseInt(datos[1]);
			
			
			
			Inventario inventario1 = new Inventario(producto, cantidad);
			inventarios.add(inventario1);
			
			
			
			linea = lector.readLine();
		}
		lector.close();
    	
    }
    
    private void cargarServicio(String Servicio) throws IOException{
    	
    	File archivo = new File(Servicio);
		BufferedReader lector = new BufferedReader(new FileReader(archivo));
		String linea = lector.readLine();
		while(linea!=null) {

			String [] datos = linea.split(";");
			
			String nombre = datos[0];
			String tipo = datos[1];
			float cantidad = Float.parseFloat(datos[2]);
			
			Servio inventario1 = new Inventario(producto, cantidad);
			inventarios.add(inventario1);
			
			
			
			linea = lector.readLine();
		}
		lector.close();
    	
    	
    }
    
    private void cargarMenuComedor(String menuComedor){

    }

    private void cargarMenuCuarto(String menuCuarto){
        
    }
    private void cargarTemporada(String temporada) {
    	
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
