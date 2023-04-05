package Clases;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;


public class App {

    private static Hotel hotel;
    
    
    public void mostrarMenu(int opcion) {
    	
    	if (opcion == 1) {
    		System.out.println("1- Cargar Informacion hotel con archivos");
    		System.out.println("2- Cargar Informacion Habitaciones manualmente");
    		System.out.println("3- Actualizar infomación del hotel");
    	}
    	else if (opcion == 2) {
    		System.out.println("1- Crear una reserva");
    		System.out.println("2- Cancelar una reserva");
    		System.out.println("3- Hacer Checkout");
			System.out.println("4- Consultar inventario");
			System.out.println("5- Condultar informaicon habitaciones");
    	}
    	else if (opcion == 3) {
    		System.out.println("1- Agregar consumo a una habitacion");
    		System.out.println("2- Agregar un pago de un consumo");
    		System.out.println("3- Hacer factura");
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

                String login = input("Ingrese su Login por favor: ");
                String contrasena = input("Ingrese su contraseña por favor: ");
                
                boolean tipo = hotel.seleccionarUsuario(login, contrasena, usuario);
				
                if (tipo) {
                	

	                mostrarMenu(usuario);
					System.out.println("0- salir de la apliacacion");
	
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
						else if (opcion == 3) {
							hotel.factura();
						}
					}
					
					else if (opcion == 0)
					{
						System.out.println("Saliendo de la aplicación ...");
						continuar = false;
					}
					else if (hotel == null)
					{
						System.out.println("Para poder ejecutar esta opción primero debe cargar un archivo de atletas.");
					}
	            }
                else {
                	System.out.println("Usuario y/o contraseña incorrecta");
					System.out.println("1- Salir de la apliacion");
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

public static void writeFile(Hotel hotel) throws IOException{

		ObjectOutputStream objOS  = new ObjectOutputStream(new FileOutputStream("hotel.bin"));

		objOS.writeObject(hotel);
		
	}

	public static void readFile(){

	}



    public static void main(String[] args) throws Exception {
        App aplicacion = new App();
		Hotel hotel1 = new Hotel();
		hotel = hotel1;
    	aplicacion.ejecutarOpciones();
		try{
			writeFile(hotel);
			}
			catch(IOException e){
				System.out.println(e.getMessage());
			}
	}	

	
}
