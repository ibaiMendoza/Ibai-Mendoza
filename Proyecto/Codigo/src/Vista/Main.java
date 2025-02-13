package Vista;

import Controlador.EnfrentamientoController;
import Controlador.EquipoController;
import Controlador.JornadaController;
import Controlador.JugadorController;
import Modelo.EnfrentamientoDAO;
import Modelo.EquipoDAO;
import Modelo.JornadaDAO;
import Modelo.JugadorDAO;

import javax.swing.*;

public class Main {
    private static EquipoController equipoController;
    private static JugadorController jugadorController;
    private static EnfrentamientoController enfrentamientoController;
    private static JornadaController jornadaController;

    public static void main(String[] args) {
        crearObjetos();
        mostrarMenu();
    }

    public static void crearObjetos()
    {
        EquipoDAO equipoDAO = new EquipoDAO();
        equipoController = new EquipoController(equipoDAO);

        JugadorDAO jugadorDAO = new JugadorDAO();
        jugadorController = new JugadorController(jugadorDAO);

        EnfrentamientoDAO enfrentamientoDAO = new EnfrentamientoDAO();
        enfrentamientoController = new EnfrentamientoController(enfrentamientoDAO);

        JornadaDAO jornadaDAO = new JornadaDAO();
        jornadaController = new JornadaController(jornadaDAO);
    }

    public static void mostrarMenu()
    {
        int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(
                    """
                            1.- Alta equipo
                            2.- Baja equipo
                            3.- Modificar equipo
                            4.- Alta jugador
                            5.- Baja jugador
                            6.- Modificar jugador
                            7.- Generar jornada
                            8.- Generar enfrentamientos
                            9.- Terminar

                            Teclea la opción elegida"""));

            switch (opcion) {
                case 1:
                    equipoController.altaEquipo();
                    break;
                case 2:
                    equipoController.bajaEquipo();
                    break;
                case 3:
                    equipoController.modificarEquipo();
                    break;
                case 4:
                    jugadorController.altaJugador();
                    break;
                case 5:
                    jugadorController.bajaJugador();
                    break;
                case 6:
                    jugadorController.modificarJugador();
                    break;
                case 7:
                    jornadaController.generarJornada();
                    break;
                case 8:
                    enfrentamientoController.generarEnfrentamientos();
                    break;
                case 9:
                    JOptionPane.showMessageDialog(null,"Finalizando...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion no existe");
            }
        }
        while(opcion != 11);

    }
}