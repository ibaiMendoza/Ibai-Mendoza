package Controlador;

import Modelo.EnfrentamientoDAO;
import Modelo.Equipo;
import Modelo.EquipoDAO;

import javax.swing.*;

public class EnfrentamientoController {
    public EnfrentamientoController(EnfrentamientoDAO enfrentamientoDAO) {


    }
    public void generarEnfrentamientos(){

        try {
            Equipo atacante = EquipoDAO.buscarEquipoEnfrentamiento();
            Equipo defensor = EquipoDAO.buscarEquipoEnfrentamiento();
            String [] opciones={atacante.getNombre(),defensor.getNombre()};

            int resultado = JOptionPane.showOptionDialog(
                    null,
                    "¿Quién ha ganado?",
                    "Resultado del Partido",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]
            );

            // Mostrar mensaje con el ganador
            if (resultado == 0) {
                JOptionPane.showMessageDialog(null, "Ganador: " + atacante.getNombre());
            } else if (resultado == 1) {
                JOptionPane.showMessageDialog(null, "Ganador: " + defensor.getNombre());
            } else {
                JOptionPane.showMessageDialog(null, "No se seleccionó ningún ganador.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al generar enfrentamientos: " + e.getMessage());
        }
    }

}