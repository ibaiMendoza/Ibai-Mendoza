package Modelo;

import Controlador.JugadorController;

import java.util.ArrayList;

public class JugadorDAO {
    public static ArrayList<Jugador> listaJugadores;

    public static void agregarJugador(Jugador jugador) {
        listaJugadores.add(jugador);

    }
    public static void altaJugador() {
        boolean continuar = false;
        do {
            try {
                Jugador jugador = JugadorController.solicitarValidarDatos();
                JugadorDAO.agregarJugador(jugador);

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (continuar);
    }

}
