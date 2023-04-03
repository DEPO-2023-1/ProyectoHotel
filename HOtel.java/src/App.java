public class App {

    private static Hotel hotel;

    public void ejecutarOpciones(){

        boolean continuar = true;
		while (continuar)
		{
			try
			{   
                String login = input("Ingrese su Login por favor: ");
                String contrasena = input("Ingrese su contraseña por favor: ");

                int tipo = hotel.seleccionarUsuario(login, contrasena);

                mostrarMenu(tipo);

                int opcion = input("Seleccione una opcion por favor: ");

                

				int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
				if (opcion_seleccionada == 1)
					ejecutarCargarAtletas();
				else if (opcion_seleccionada == 2 && calculadora != null)
					ejecutarAtletasPorAnio();
				else if (opcion_seleccionada == 14)
				{
					System.out.println("Saliendo de la aplicación ...");
					continuar = false;
				}
				else if (calculadora == null)
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

    }
}
