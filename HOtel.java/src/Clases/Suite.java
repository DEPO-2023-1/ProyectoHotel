package Clases;

import java.util.ArrayList;

public class Suite extends Habitacion{

    public Suite(ArrayList<Temporada> temporadas, ArrayList<Reserva> reservas, ArrayList<Grupo> grupos, Factura factura,
            String idHabitacion, Boolean disponible, String ubicacion, int capacidadNino, int capaciodadAdulto,
            Boolean balcon, Boolean cocina, Boolean vista, double precioI, double precioF) {
        super(temporadas, reservas, grupos, factura, idHabitacion, disponible, ubicacion, capacidadNino, capaciodadAdulto,
                balcon, cocina, vista, precioI, precioF);
        //TODO Auto-generated constructor stub
    }

}
