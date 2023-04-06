package Clases;
import java.util.Date;

import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.io.*;



public class Hotel {
	

	private ArrayList<Grupo> grupos;
    private ArrayList<Servicio> servicios;
    private ArrayList<ConsumoHot> consumosHotel;
    private ArrayList<Habitacion> habitaciones;
    private ArrayList<Inventario> inventarios;
    private ArrayList<MenuRestaurante> productos;

    public Hotel(){
    	this.grupos = new ArrayList<Grupo>();
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
    	int valor=0;
    	String IDHabitacion = input("Ingrese la habitacion");
    	String servicio = input("Ingrese el servcio consumido");
    	int menu_o_servicio = Integer.parseInt(input("Ingrese 1 si su servicio es de ¨Menu Restaurante¨, de lo contrario ingrese 2 si su servicio es de otra clase"));
    	
        factura(IDHabitacion, servicio, menu_o_servicio);
        for (Habitacion h: habitaciones) {
			String nombre = h.getIdHabitacion();
			if (nombre.equals(IDHabitacion)) {
				h.agregarConsumo(IDHabitacion, servicio);
				break;
			}
    	}
        for(Inventario i:inventarios){
            if(servicio.equals(i.getProducto())){
                valor=i.getCantidad()-1;
                i.setCantidad(valor);
                ConsumoHot servicio1=new ConsumoHot(IDHabitacion, "consumo",servicio);
                consumosHotel.add(servicio1);
                if(i.getCantidad()==0){
                    inventarios.remove(i);
                }
                break;
            }
        }
    	
    	
    }
    public void agregarPago(){
    	int valor=0;
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
        for(Inventario i:inventarios){
            if(servicio.equals(i.getProducto())){
                valor=i.getCantidad()-1;
                i.setCantidad(valor);
                ConsumoHot servicio1=new ConsumoHot(IDHabitacion, "pago",servicio);
                consumosHotel.add(servicio1);
                if(i.getCantidad()==0){
                    inventarios.remove(i);
                break;
                }
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
        System.out.println("Proceso exitoso");
    }

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
                    for(Servicio s: servicios){
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
    	
    	String habitaciones = input("Ingrese la ruta de archivo con la informacion de las habitaciones");
    	String inventario = input("Ingrese la ruta de archivo con la informacion del inventario");
    	String Servicio = input("Ingrese la ruta de archivo con la informacion de los servicios");
    	String restaurante = input("Ingrese la ruta de archivo con la informacion de los productos del restaurante");
    	String temporada = input("Ingrese la ruta de archivo con la informacion de las temporada");
    	
    	cargarHabitacion(habitaciones);
    	cargarInventario(inventario);
    	cargarServicio(Servicio);
    	cargarRestaurante(restaurante);
    	cargarTemporada(temporada);

		System.out.println("La carga ha sido exitosa");
    	
    }

    public void cargarHotelManual(){

		System.out.println("Ingrese la opcion que quiere cargar");
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
	}

    public void actualizarInformacion(){

		String respuesta = "Hubo un error";
		boolean aceptado = false;
		System.out.println("Ingrese la opcion que quiere actualizar");
		System.out.println("1- Actualizar informaicon habitaciones");
		System.out.println("2- Actualizar informaicon tarifas en temporadas");
		System.out.println("3- Actualizar informaicon servicios");
		System.out.println("4- Actualizar informaicon productos de los menú");
		int opcion = Integer.parseInt(input(""));

		if (opcion == 1) {
			System.out.println("\nIngrese la opcion que quiere actualizar");
			System.out.println("1- Actualizar capacidad maxima de niños");
			System.out.println("2- Actualizar capacidad maxima de adultos");
			System.out.println("3- Actualizar precio por tipo de habitacion");
			int eleccion = Integer.parseInt(input(""));

			if (eleccion == 3) {
				String tipo = input("\nIngrese el tipo de la habitacion");
				for(Habitacion h: habitaciones) {
					String tipo2 = h.getTipo();
					if (tipo.equals(tipo2)) {
						float cambio = Float.parseFloat(input("Ingrese el nuevo precio"));
						h.setPrecioI(cambio);
						aceptado = true;
					}
				}
			}

			else {       
				String IDHabitacion = input("\nIngrese el ID de la habitacion");
				for(Habitacion h: habitaciones) {
					String nombre = h.getIdHabitacion();
					if (nombre.equals(IDHabitacion)) {
						if (eleccion == 1) {
							int cambio = Integer.parseInt(input("Ingrese la nueva cantidad"));
							h.setCapacidadNino(cambio);
						}
						if (eleccion == 2) {
							int cambio = Integer.parseInt(input("Ingrese la nueva cantidad"));
							h.setCapaciodadAdulto(cambio);
						}
						aceptado = true;
						break;
					}

				}
			}
		}

		else if (opcion == 2) {
			String tipo = input("\nIngrese el tipo de la habitacion");
			for(Habitacion h: habitaciones) {
				String tipo2 = h.getTipo();
				if (tipo.equals(tipo2)) {

					int inicialAnio = Integer.parseInt(input("Ingrese el año del dia de inicio de la temporada"));
					int inicialMes = Integer.parseInt(input("Ingrese el mes de día del inicio de la temporada"));
					int inicialDia = Integer.parseInt(input("Ingrese el día del inicio de la temporada"));
					int finalAnio = Integer.parseInt(input("Ingrese el año del dia del final de la temporada"));
					int finalMes = Integer.parseInt(input("Ingrese el mes de día del final de la temporada"));
					int finalDia = Integer.parseInt(input("Ingrese el día del final de la temporada"));

					float cambio = Float.parseFloat(input("Ingrese el nuevo precio"));

					@SuppressWarnings("deprecation")
					Date inicialDate = new Date(inicialAnio, inicialMes, inicialDia);
					@SuppressWarnings("deprecation")
					Date finalDate = new Date(finalAnio, finalMes, finalDia);

					h.setPrecioTemporada(inicialDate, finalDate, cambio);
					aceptado = true;
				}
			}
		}

		else if (opcion == 3) {
			String servicio = input("Ingrese el servicio que quiere actualizar");
			for (Servicio s: servicios) {
				String servicio2 = s.getNombre();
				if (servicio.equals(servicio2)) {
					float cambio = Float.parseFloat(input("Ingrese el nuevo precio del servicio"));
					s.setPrecio(cambio);
					aceptado = true;
					break;
				}
			}
		}

		else if (opcion == 4) {

			String tipo = input("Ingrese el tipo de menú de su producto al que quiere modificar (ServicioHabitacion o Comedor)");

			for(MenuRestaurante r: productos) {
				String tipo2 = r.getTipo();
				if (tipo.equals(tipo2)) {
					System.out.println("\nIngrese la opcion que quiere actualizar");
					System.out.println("1- Actualizar precio del producto");
					System.out.println("2- Actualizar hora de inicio de disponibilidad del producto");
					System.out.println("3- Actualizar hora del final de la disponibilidad del producto");
					int eleccion = Integer.parseInt(input(""));

					if (eleccion == 1) {
						float cambio = Float.parseFloat(input("Ingrese el nuevo precio"));
						r.setPrecio(cambio);
					}
					else if (eleccion == 2) {
						String cambio = input("Ingrese la nueva hora");
						r.setHoraInicio(cambio);
					}
					else if (eleccion == 2) {
						String cambio = input("Ingrese la nueva hora");
						r.setHoraFinal(cambio);
					}
					aceptado = true;
					break;
				}
			}

		}


		if (aceptado) {
			System.out.println(respuesta);
		}
		else {
			System.out.println("Hubo un error, no se pudo hacer el cambio");
		}

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
			int cantidad = Integer.parseInt(datos[2]);
			
			Servicio inventario1 = new Servicio(nombre, tipo, cantidad);
			servicios.add(inventario1);
			
			linea = lector.readLine();
		}
		lector.close();
    	
    	
    }
    

	private void cargarRestaurante(String rutRestaurante) throws IOException{

    	File archivo = new File(rutRestaurante);
		BufferedReader lector = new BufferedReader(new FileReader(archivo));
		String linea = lector.readLine();
		while(linea!=null) {

			String [] datos = linea.split(";");

			String tipo = datos[0];
			String nombre = datos[1];
			float precio = Float.parseFloat(datos[2]);
			String horaInicio = datos[3];
			String horaFinal = datos[4];


			if (tipo.equals("Comedor")) {
				Comedor producto = new Comedor(nombre, tipo, precio, horaInicio, horaFinal);
				productos.add(producto);

			}
			if (tipo.equals("ServicioHabitacion")) {
				ServicioHab producto = new ServicioHab(nombre, tipo, precio, horaInicio, horaFinal);
				productos.add(producto);
			}

			linea = lector.readLine();
		}
		lector.close();
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
