package Clases;
import java.util.Date;

import java.io.FileReader;
import java.io.BufferedReader;
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

    public boolean seleccionarUsuario(String login, String contraseña, int usuario){
		String direccion = "";
		boolean result = false;
		try{
			
			if (usuario == 1){
				direccion = "./data/admins.txt";
			}
			else if (usuario == 2){
				direccion = "./data/recepcionistas.txt";
			}
			else if (usuario == 3){
				direccion = "./data/empleado.txt";
			}

			FileReader fileReader = new FileReader(direccion);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equals(login) && parts[1].equals(contraseña)) {
                    result = true;
                    break;
				}
			}
            
			bufferedReader.close();
		}
		catch (Exception e) {
			System.out.println("error al leer el archivo " + direccion);
		}
		return result;
    }

    public void agregarConsumo(){
    	
    	String IDHabitacion = input("Ingrese la habitacion");
    	String servicio = input("Ingrese el servcio consumido");
    	
    	for (Habitacion h: habitaciones) {
			String nombre = h.getIdHabitacion();
			if (nombre.equals(IDHabitacion)) {
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
			if (nombre.equals(IDHabitacion)) {
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
        if (IDHabitacion.equals("")) {
        	System.out.println("lo siento no hay cupos disponibles");
        }
		else if (IDHabitacion.equals("no")){
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
				float precioIntermedio = h.getPrecioF();
				float precioFinal = h.calcularPrecioTotal(precioIntermedio, inicialDate, finalDate);
				System.out.println("El valor de su reserva es: " + precioFinal);
        		System.out.println("1- Aceptar precio");
        		System.out.println("2- Cancelar reserva");
        		int nuevo = Integer.parseInt(input(""));
        		if (nuevo == 2) {
        			respuesta = "";
        		}
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
    		if (IDHabitacion.equals(nomHabitacion)) {
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

    private void cargarHabitacion(String rutHabitaciones) throws IOException{
    	
    	File archivo = new File(rutHabitaciones);
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
			
			if (tipo.equals("Standar")) {
				Standard habitacion = new Standard(idHabitacion, tipo, ubicacion, capacidadNino,
						capaciodadAdulto, balcon, cocina, vista, PrecioI);
				habitaciones.add(habitacion);
				
			}
			else if (tipo.equals("Suite")) {
				Suite habitacion = new Suite(idHabitacion, tipo, ubicacion, capacidadNino,
						capaciodadAdulto, balcon, cocina, vista, PrecioI);
				habitaciones.add(habitacion);
				
			}
			else if (tipo.equals("SuitDoble")) {				SuitDoble habitacion = new SuitDoble(idHabitacion, tipo, ubicacion, capacidadNino,
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
			
			
			if (tipo.equals("Administrador")) {
				Administrador usuario = new Administrador(contrasena, login);
				usuarios.add(usuario);
				
			}
			if (tipo.equals("Recepcionista")) {
				Recepcionista usuario = new Recepcionista(contrasena, login);
				usuarios.add(usuario);
				
			}
			if (tipo.equals("Empleado")) {
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
			
			Servicio inventario1 = new Servicio(nombre, tipo, cantidad);
			inventarios.add(inventario1);
			
			linea = lector.readLine();
		}
		lector.close();
    	
    	
    }
    
    private void cargarMenuComedor(String menuComedor){

    }

    private void cargarMenuCuarto(String menuCuarto){
        
    }
    private void cargarTemporada(String temporada) throws IOException {
    	
		File archivo = new File(temporada);
		BufferedReader lector = new BufferedReader(new FileReader(archivo));
		String linea = lector.readLine();
		while(linea!=null) {

			String [] datos = linea.split(";");
			String [] dateInicial = datos[0].split(":");
			int inicialAnio = Integer.parseInt(dateInicial[0]);
			int inicialMes = Integer.parseInt(dateInicial[1]);
			int inicialDia = Integer.parseInt(dateInicial[2]);
			String [] dateFinal = datos[1].split(":");
			int finalAnio = Integer.parseInt(dateFinal[0]);
			int finalMes = Integer.parseInt(dateFinal[1]);
			int finalDia = Integer.parseInt(dateFinal[2]);
			
			@SuppressWarnings("deprecation")
			Date inicialDate = new Date(inicialAnio, inicialMes, inicialDia);
			@SuppressWarnings("deprecation")
			Date finalDate = new Date(finalAnio, finalMes, finalDia);

			float aumento = Float.parseFloat(datos[2]);
			
			for (Habitacion h: habitaciones){
				h.addTemporada(inicialDate, finalDate, aumento);
			}
			
			linea = lector.readLine();
		}
		lector.close();


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
