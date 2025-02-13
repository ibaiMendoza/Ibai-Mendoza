package Modelo;

import javax.swing.*;
import java.util.ArrayList;
/*     private String idEquipo;
    private String nombre;
    private LocalDate fechaFund;*/
public class EquipoDAO {
    public static ArrayList<Equipo> listaEquipos;
    private static ArrayList<Jugador> listaJugadores;

    public static void agregarEquipo(Equipo equipo) {
        listaEquipos.add(equipo);
    }

    public static void borrarEquipo(Equipo i) {
        listaEquipos.remove(i);
    }

    public static Equipo buscarEquipo(String idEquipo) {
        boolean encontrado = true;
        Equipo equipo = null;
        for (int i = 0; (i < listaEquipos.size() && encontrado); i++) {
            if (listaEquipos.get(i).getIdEquipo().equals(idEquipo)) {
                equipo = listaEquipos.get(i);
                encontrado = false;
            }
        }
        return equipo;
    }

    public static void agregarJugador(Jugador jugador) {
        listaJugadores.add(jugador);
    }

    public static void borrarJugador(Jugador jugador) {
        listaJugadores.remove(jugador);
    }

    public static Jugador buscarJugador(String idJugador) {
        boolean encontrado = true;
        Jugador jugador = null;
        for (int i = 0;(i < listaJugadores.size() && encontrado); i++) {
            if (listaJugadores.get(i).getIdJugador().equals(idJugador)) {
                borrarJugador(listaJugadores.get(i));
                encontrado = false;
            }
        }
        return jugador;
    }
}
