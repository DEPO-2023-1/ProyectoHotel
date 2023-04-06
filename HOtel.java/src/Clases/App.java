package Clases;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class App {
    
	public static Hotel hotel;
    
    public void mostrarMenu(int opcion) {
    	
    	if (opcion == 1) {
			System.out.println("\n////////Bienvenido al menu de administradores/////////");
    		System.out.println("\n1- Cargar Informacion hotel con archivos");
    		System.out.println("\n2- Cargar Informacion Habitaciones manualmente");
    		System.out.println("\n3- Actualizar infomación del hotel");
    	}
    	else if (opcion == 2) {
			System.out.println("\n ////////Bienvenido al menu de recepción////////");
    		System.out.println("\n1- Crear una reserva");
    		System.out.println("\n2- Cancelar una reserva");
    		System.out.println("\n3- Hacer Checkout");
			System.out.println("\n4- Consultar inventario");
			System.out.println("\n5- Condultar informaicon habitaciones");
    	}
    	else if (opcion == 3) {
			System.out.println("\n////////Bienvenido al menu de administradores////////");
    		System.out.println("\n1- Agregar consumo a una habitacion");
    		System.out.println("\n2- Agregar un pago de un consumo");
    		System.out.println("\n3- Hacer factura");
    	}
    	
    	
    }

    public void ejecutarOpciones() throws IOException{

        boolean continuar = true;
		while (continuar)
		{
			try
			{   
				System.out.println("\nPor favor selecciones su tipo de usuario\n");
				System.out.println("1- Administrador");
				System.out.println("2- Recepcionista");
				System.out.println("3- Empleado\n");

				int usuario = Integer.parseInt(input(""));

                String login = input("Ingrese su Login por favor ");
                String contrasena = input("Ingrese su contraseña por favor ");
                
                boolean tipo = hotel.seleccionarUsuario(login, contrasena, usuario);
				
                if (tipo) {
                	

	                mostrarMenu(usuario);
					System.out.println("\n0- salir de la aplicacion\n");
	
	                int opcion = Integer.parseInt((input("Seleccione una opcion por favor: ")));
	
					if (usuario == 1) {
						if (opcion == 1) {
							hotel.cargarHotel();
						}
						else if (opcion == 2) {
							hotel.cargarHotelManual();
						}
						else if (opcion == 3) {
							hotel.actualizarInformacion();
						}
					}
					
					else if (usuario == 2) {
						if (opcion == 1) {
							hotel.crearReserva();
						}
						else if (opcion == 2) {
							hotel.cancelarReserva();
						}
						else if (opcion == 3) {
							hotel.checkOut();
						}
						else if (opcion == 4) {
							hotel.consultarInventario();
						}
						else if (opcion == 5) {
							hotel.consultarHabitacion();
						}
					}
					
					else if (usuario == 3) {
						if (opcion == 1) {
							hotel.agregarConsumo();
						}
						else if (opcion == 2) {
							hotel.agregarPago();
						}
					}
					
					if (opcion == 0)
					{
						System.out.println("Saliendo de la aplicación ...");
						continuar = false;
					}
	            }
                else {
                	System.out.println("Usuario y/o contraseña incorrecta");
					System.out.println("\n1- Salir de la aplicacion");
					System.out.println("2- Seguir");
					int opcion = Integer.parseInt(input(""));
					if (opcion == 1){
						continuar = false;
					}
                }
			}
			catch (NumberFormatException e)
			{
				System.out.println("Debe seleccionar uno de los números de las opciones.");
			}
		}
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


	public static void serializarObjeto(Hotel hotel) {
        try (FileOutputStream fos = new FileOutputStream("hotel.bin");
                ObjectOutputStream salida = new ObjectOutputStream(fos);) {
            salida.writeObject(hotel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	public static Hotel deserializarObjeto(Class<Hotel> claseObjetivo) {
        Hotel objeto = null;
        try (FileInputStream fis = new FileInputStream("hotel.bin");
                ObjectInputStream entrada = new ObjectInputStream(fis);) {
            objeto = (Hotel) entrada.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objeto;
    }




    public static void main(String[] args) throws Exception {
        App aplicacion = new App();
		
		Hotel h1 = deserializarObjeto(Hotel.class);

		if (h1 != null){
		hotel = h1;
		}
		else {
			System.out.println("hola");
		Hotel hotel1 = new Hotel();
		hotel = hotel1;
		}
		
    	aplicacion.ejecutarOpciones();
		serializarObjeto(hotel);
		
	}	

	
}
