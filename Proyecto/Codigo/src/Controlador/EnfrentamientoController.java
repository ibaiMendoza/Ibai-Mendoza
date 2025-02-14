package Controlador;

import Modelo.Equipo;
import Modelo.EquipoDAO;

import javax.swing.*;
import java.util.*;

public class EnfrentamientoController {
    private ArrayList<Equipo> equiposGanadores;
    private List<String> enfrentamientos; // Aquí almacenamos los enfrentamientos de la jornada

    public void generarEnfrentamientos() {
        List<Equipo> equiposDisponibles = new ArrayList<>(EquipoDAO.listaEquipos);
        Collections.shuffle(equiposDisponibles); // Mezcla aleatoria

        System.out.println("\nGenerando enfrentamientos...");

        enfrentamientos = new ArrayList<>(); // Reiniciar la lista de enfrentamientos
        equiposGanadores = new ArrayList<>(); // Reiniciar la lista de ganadores

        for (int i = 1; i <= equiposDisponibles.size() / 2; i++) {
            Equipo atacante = equiposDisponibles.remove(0);
            Equipo defensor = equiposDisponibles.remove(0);
            String enfrentamiento = atacante.getNombre() + " vs " + defensor.getNombre();

            enfrentamientos.add(enfrentamiento); // Guardamos el enfrentamiento en la lista
            JOptionPane.showMessageDialog(null, "Este va a ser el enfrentamiento número " + i + ": " + enfrentamiento);
        }

        preguntarResultados();
    }

    private void preguntarResultados() {
        for (String enfrentamiento : enfrentamientos) {
            String[] nombresEquipos = enfrentamiento.split(" vs ");
            Equipo equipo1 = buscarEquipoPorNombre(nombresEquipos[0]);
            Equipo equipo2 = buscarEquipoPorNombre(nombresEquipos[1]);

            String[] opciones = {equipo1.getNombre(), equipo2.getNombre()};
            int resultado = JOptionPane.showOptionDialog(
                    null,
                    "¿Quién ha ganado?",
                    enfrentamiento,
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]
            );

            Equipo equipoGanador = null;
            if (resultado == 0) {
                equipoGanador = equipo1;
            } else if (resultado == 1) {
                equipoGanador = equipo2;
            }

            equiposGanadores.add(equipoGanador);
        }

        mostrarResultadosFinales();
    }

    private Equipo buscarEquipoPorNombre(String nombre) {
        for (Equipo equipo : EquipoDAO.listaEquipos) {
            if (equipo.getNombre().equals(nombre)) {
                return equipo;
            }
        }
        return null;
    }

    private void mostrarResultadosFinales() {
        StringBuilder mensaje = new StringBuilder("Resultados de la jornada:\n");

        for (Equipo ganador : equiposGanadores) {
            mensaje.append("Ganador: ").append(ganador.getNombre()).append("\n");
        }

        JOptionPane.showMessageDialog(null, mensaje.toString());
    }
}
