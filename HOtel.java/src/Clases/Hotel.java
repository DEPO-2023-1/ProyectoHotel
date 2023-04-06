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
    private ArrayList<Inventario> inventarios;
    private ArrayList<MenuRestaurante> productos;

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
				direccion = "HOtel.java/data/admins.txt";
			}
			else if (usuario == 2){
				direccion = "HOtel.java/data/recepcionistas.txt";
			}
			else if (usuario == 3){
				direccion = "HOtel.java/data/empleado.txt";
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
        int menu_o_servicio = Integer.parseInt(input("Ingrese 1 si su servicio es de ¨Menu Restaurante¨, de lo contrario ingrese 2 si su servicio es de otra clase"));
    	
        factura(IDHabitacion, servicio, menu_o_servicio);
    	for (Habitacion h: habitaciones) {
			String nombre = h.getIdHabitacion();
			if (nombre.equals(IDHabitacion)) {
				h.agregarPago(IDHabitacion, servicio);
				break;
			}
    	}
    	
    }
    
    public void factura(String IDHabitacion, String servicio, int menu_o_servicio) {
        float valor=0;
    	System.out.println("Gracias por su compra");
        System.out.println("-----------------------------------------------------\n");
        System.out.println("Detalles de compra:\n");
        System.out.println("Habitacion........................................"+IDHabitacion+"\n");
        System.out.println("Servicio..........................................Valor");
        if(menu_o_servicio==1){
            for(MenuRestaurante m: productos){
                if(servicio.equals(m.getNombre())){
                    valor = m.getPrecio();
                }
            }
        }else if(menu_o_servicio==2){
            for(Servicio s: servicios){
                if(servicio.equals(s.getNombre())){
                    valor = s.getPrecio();
                }
            }
        }
        String valors = Float.toString(valor);
        System.out.println(servicio+".........................................."+valors);
        System.out.println("Pago exitoso");
    }

<<<<<<< HEAD
=======
	public void consultarHabitacion(){

		String IDHabitacion = input("Ingrese el ID de la habitacion");
		
		System.out.println("\nIngrese la opcion que quiere consultar");
    	System.out.println("1- Ubicacion");
    	System.out.println("2- Tipo");
    	System.out.println("3- Capacidad maxima de niños");
		System.out.println("4- Capacidad maxima de adultos");
		System.out.println("5- Balcon");
		System.out.println("6- Cocina");
		System.out.println("7- Vista");
		System.out.println("8- Precio");
		System.out.println("9- Reservadas en una determinada fecha");

		int opcion = Integer.parseInt(input(""));

		if (opcion == 9){
			for(Grupo g: grupos) {
				String nombre = g.getIDHabitacion();
				if (nombre.equals(IDHabitacion)) {
					
					Date reservaInicio = g.getReservaInicio();
					Date reservaFinal = g.getReservaFinal();
					
					int inicialAnio = Integer.parseInt(input("Ingrese el año del dia de la reserva"));
			        int inicialMes = Integer.parseInt(input("Ingrese el mes de día de la reserva"));
			        int inicialDia = Integer.parseInt(input("Ingrese el día de la reserva"));
			        
			        @SuppressWarnings("deprecation")
					Date inicialDate = new Date(inicialAnio, inicialMes, inicialDia);

			        if ((reservaInicio.before(inicialDate)) && (reservaFinal.after(inicialDate))) {
			        	ArrayList<String> nombresList = g.getNombresHuespedes();
						System.out.println("Los huespeds que ocupan esta habitacion en esta fecha son:");
			        	for(String s: nombresList) {
			        		System.out.println(s);
			        	}
			        }
				}
			}
		}
		
		else {
			for (Habitacion h:habitaciones) {
				String nombre = h.getIdHabitacion();
				if (nombre.equals(IDHabitacion)) {
					if (opcion == 1) {
						System.out.println(h.getUbicacion());
					}
					else if (opcion == 2) {
						System.out.println(h.getTipo());
					}
					else if (opcion == 3) {
						System.out.println(h.getCapacidadNino());
					}
					else if (opcion == 4) {
						System.out.println(h.getCapaciodadAdulto());
					}
					else if (opcion == 5) {
						System.out.println(h.getBalcon());
					}
					else if (opcion == 6) {
						System.out.println(h.getCocina());
					}
					else if (opcion == 7) {
						System.out.println(h.getVista());
					}
					else if (opcion == 8) {
						System.out.println(h.getPrecioF());
					}
				}
			}
		}



	}

	public void consultarInventario(){
		
		System.out.println("\nIngrese la opcion que quiere consultar");
    	System.out.println("1- Todo el inventario");
    	System.out.println("2- La cantidad de un producto");
    	
    	int opcion = Integer.parseInt(input(""));
    	
    	if (opcion == 1) {
    		
    		System.out.println("\nEl inventario es el siguiente:\n");
    		System.out.println("\nProducto-------------cantidad\n");
    		for (Inventario i: inventarios) {
    			String nombre = i.getProducto();
    			int cantidad = i.getCantidad();
    			System.out.println(nombre+"-------------"+cantidad);
    		}
    		
    	}
    	
    	else if (opcion == 2) {
    		String producto = input("Ingrese el nombre del producto");
    		System.out.println("La cantidad de su producto es");
    		for (Inventario i: inventarios) {
    			String nombre = i.getProducto();
    			if (nombre.equals(producto)) {
    				int cantidad = i.getCantidad();
    				System.out.println("La cantidad de su producto es: "+cantidad);
    			}
    		}
    	}

	}

>>>>>>> a2c23bf7ce9b84389d56b8517ea5933eec7de3f8
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
        	Grupo grupo = new Grupo(IDHabitacion, inicialDate, finalDate);
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
	        System.out.println("Se ha agregado su reserva");
	        
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
    	
    	String respuesta = "Por favor espere que pasen 48 horas despues de reservar para cancelar la reserva";
    	boolean verdad = Boolean.parseBoolean(input("Ingrese true si su reserva se hizo hace mas de 48 horas, si no ingrese false"));
    	if (verdad) {
    		String IDHabitacion = input("Ingrese el ID de su reserva");
    		
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
            
            for (Habitacion h: habitaciones) {
            	String nombre = h.getIdHabitacion();
            	if (nombre.equals(IDHabitacion)) {
            		h.delreserva(inicialDate, finalDate);
            	}
            }
            
            for (Grupo g: grupos) {
            	String nombre2 = g.getIDHabitacion();
            	Date dateInicio = g.getReservaInicio();
    			Date dateFinal = g.getReservaFinal();;
    			if ((nombre2.equals(IDHabitacion))&&(dateInicio.equals(inicialDate)) && (dateFinal.equals(finalDate))) {
    				grupos.remove(g);
    			}
            }
            respuesta  = "Reserva cancelada";
    	}
    	System.out.println(respuesta);
    
    }

    public void checkOut(){
        float valor =0;
        String id = input("Ingrese el ID de su habitación");
        System.out.println("");
        System.out.println("");
    	System.out.println("Gracias por su estadía ");
        System.out.println("----------------------------------------------");
        
        for(Habitacion h: habitaciones){
            if(id.equals(h.getIdHabitacion())){
                System.out.println("Servicio.....................................Valor");
                for(ConsumoHab ch: h.getConsumos()){
                    for(Servicio s: ch.getServicios()){
                        if(ch.getServicio().equals(s.getNombre())){
                            valor=s.getPrecio();
                            String valors=Float.toString(valor);
                            System.out.println(ch+".........................................."+valors);
                            break;
                        }
                    }
                    h.getConsumos().remove(ch);
                }
                break;
            }
        }
        System.out.println("----------------------------------------------------------");
        System.out.println("Tenga buena tarde");

    }

    public void cargarHotel() throws IOException{
    	
<<<<<<< HEAD
    	String Habitaciones = input("Ingrese la ruta de archivo con la informacion de las habitaciones");
    	String Usuario = input("Ingrese la ruta de archivo con la informacion de los usuarios");
=======
    	String habitaciones = input("Ingrese la ruta de archivo con la informacion de las habitaciones");
>>>>>>> a2c23bf7ce9b84389d56b8517ea5933eec7de3f8
    	String inventario = input("Ingrese la ruta de archivo con la informacion del inventario");
    	String Servicio = input("Ingrese la ruta de archivo con la informacion de los servicios");
    	String menuComedor = input("Ingrese la ruta de archivo con la informacion del menu del comedor");
    	String menuCuarto = input("Ingrese la ruta de archivo con la informacion del menu del servicio al cuarto");
    	String temporada = input("Ingrese la ruta de archivo con la informacion de las temporada");
    	
<<<<<<< HEAD
    	cargarHabitacion(Habitaciones);
    	cargarUsuarios(Usuario);
=======
    	cargarHabitacion(habitaciones);
>>>>>>> a2c23bf7ce9b84389d56b8517ea5933eec7de3f8
    	cargarInventario(inventario);
    	cargarServicio(Servicio);
    	cargarMenuComedor(menuComedor);
    	cargarMenuCuarto(menuCuarto);
    	cargarTemporada(temporada);

		System.out.println("La carga ha sido exitosa");
    	
    }

    public void cargarHotelManual(){
<<<<<<< HEAD

=======
    	
    	System.out.println("Ingrese la opcion que quiere actualizar");
    	System.out.println("1- Cargar informaicon habitaciones");
    	System.out.println("2- Cargar informaicon servicios");
    	int opcion = Integer.parseInt(input(""));
    	
	    if (opcion == 1) {
	    	String idHabitacion = input("Ingrese el ID de la habitacion");
			String tipo = input("Ingrese el tipo de la habitacion");
			String ubicacion = input("Ingrese la ubicacion de la habitacion");
			int capacidadNino = Integer.parseInt(input("Ingrese la cantidad maxima de niños de la habitacion"));
			int capaciodadAdulto = Integer.parseInt(input("Ingrese la cantidad maxima de adultos de la habitacion"));
			Boolean balcon = Boolean.parseBoolean(input("Ingrese true si la habitacion tiene Balcon, si no ingrese false"));
			Boolean cocina = Boolean.parseBoolean(input("Ingrese true si la habitacion tiene Cocina, si no ingrese false"));
			Boolean vista = Boolean.parseBoolean(input("Ingrese true si la habitacion tiene Vista, si no ingrese false"));
			float PrecioI = Float.parseFloat(input("Ingrese el precio base de la habitacion"));
	    	
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
			else if (tipo.equals("SuitDoble")) {				
				SuitDoble habitacion = new SuitDoble(idHabitacion, tipo, ubicacion, capacidadNino,
						capaciodadAdulto, balcon, cocina, vista, PrecioI);
				habitaciones.add(habitacion);
			}
	    }
	    
	    else if (opcion == 2) {
	    	
	    	String tipo = input("Ingrese si es menu del comedor o del servicio a la habitacion");
			String nombre = input("Ingrese el nombre del producto");
			float precio = Float.parseFloat(input("Ingrese el precio base del producto"));
			String horaInicio = input("Ingrese el la hora de inicio de disponibilidad del producto");
			String horaFinal = input("Ingrese el la hora final de disponibilidad del producto");
			
			
			if (tipo.equals("Comedor")) {
				Comedor producto = new Comedor(nombre, tipo, precio, horaInicio, horaFinal);
				productos.add(producto);
				
			}
			if (tipo.equals("ServicioHabitacion")) {
				ServicioHab producto = new ServicioHab(nombre, tipo, precio, horaInicio, horaFinal);
				productos.add(producto);
			}
	    	
	    }
	    
>>>>>>> a2c23bf7ce9b84389d56b8517ea5933eec7de3f8
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

<<<<<<< HEAD
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
			
=======
>>>>>>> a2c23bf7ce9b84389d56b8517ea5933eec7de3f8
			linea = lector.readLine();
		}
		lector.close();
	}
    	
<<<<<<< HEAD
    	

    private void cargarInventario(String inventario) throws IOException{
=======
    private void cargarInventario(String rutinventario) throws IOException{
>>>>>>> a2c23bf7ce9b84389d56b8517ea5933eec7de3f8
    	
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
    	/* 
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
    	*/
    	
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
