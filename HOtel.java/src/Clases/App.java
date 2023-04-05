package Clases;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class App {

    private static Hotel hotel;
    
    
    public void mostrarMenu(int opcion) {
    	
    	if (opcion == 1) {
    		System.out.println("1- Cargar Informacion hotel con archivos");
    		System.out.println("2- Cargar Informacion hotel manualmente");
    		System.out.println("3- Actualizar infomación hotel");
    	}
    	else if (opcion == 2) {
    		System.out.println("1- Crear una reserva");
    		System.out.println("2- Cancelar una reserva");
    		System.out.println("3- Hacer Checkout");
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
                String login = input("Ingrese su Login por favor: ");
                String contrasena = input("Ingrese su contraseña por favor: ");

                int tipo = hotel.seleccionarUsuario(login, contrasena);

                mostrarMenu(tipo);

                int opcion = Integer.parseInt((input("Seleccione una opcion por favor: ")));

				if (tipo == 1) {
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
				
				if (tipo == 2) {
					if (opcion == 1) {
						hotel.crearReserva();
					}
					else if (opcion == 2) {
						hotel.cancelarReserva();
					}
					else if (opcion == 3) {
						hotel.checkOut();
					}
				}
				
				if (tipo == 2) {
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
				else
				{
					System.out.println("Por favor seleccione una opción válida.");
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




    public static void main(String[] args) throws Exception {
        App aplicacion = new App();
        aplicacion.ejecutarOpciones();

    }
}
