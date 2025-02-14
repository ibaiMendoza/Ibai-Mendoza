package Controlador;

import Excepciones.DatoNoValido;
import Modelo.Equipo;
import Modelo.EquipoDAO;
import Modelo.Jugador;
import Modelo.JugadorDAO;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JugadorController {
    public JugadorController(JugadorDAO jugadorDAO) {
    }

    public static Jugador solicitarValidarDatos() {
        // Copia de la versión anterior.
        String idJugador = solicitarDato("ID Jugador", "Teclea el equipo al que pertenece", "^[0-9]{4}[A-Z]{1}$");
        String nombre = solicitarDato("Nombre", "Teclea el nombre del jugador", "^[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ\\s]*$");
        String apellido = solicitarDato("Apellido","Teclea el apellido del jugador","^[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ\\s]*$");
        String nacionalidad = solicitarDato("Nacionalidad","Teclea la nacionalidad del jugador","^[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ]*$");
        LocalDate fechaNacimiento = solicitarFecha();
        String nickname = solicitarDato("Nickname","Teclea el nickname del jugador","^[a-zA-Z0-9_]{4,}$");
        String rol = solicitarDato("Rol","Teclea el rol del jugador","^[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ\\s]{3,}$");
        Double sueldo = Double.valueOf(solicitarDato("Sueldo", "Tecle el sueldo del jugador", "^[0-9]{5}$"));
        String idEquipo = solicitarDato("ID", "Teclea el ID del equipo al que pertenece", "^[A-Z]{1}[0-9]{3}$");
        Equipo equipo = EquipoDAO.buscarEquipo(idEquipo);

        Jugador j = new Jugador(idJugador, nombre, apellido, nacionalidad, fechaNacimiento, nickname, rol, sueldo, equipo);
        return j;
    }

    public static String solicitarDato(String dato, String mensaje, String expresionRegular)
    {
        String variable = "";
        boolean error;
        do
        {
            try {
                variable = JOptionPane.showInputDialog(mensaje);
                if (variable.isEmpty())
                    throw new DatoNoValido(dato + " es un campo obligatorio");
                Pattern pat = Pattern.compile(expresionRegular);
                Matcher mat = pat.matcher(variable);
                if (!mat.matches())
                    throw new DatoNoValido(dato + " no tiene un formato adecuado");
                error = false;
            } catch (DatoNoValido e) {
                error = true;
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        while(error);
        return variable;
    }

    public static LocalDate solicitarFecha() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaS = JOptionPane.showInputDialog("Ingrese la fecha de nacimiento: ");
        LocalDate fecha = LocalDate.parse(fechaS, formatter);
        return fecha;
    }

    public static void bajaJugador(){
        boolean continuar = false;
        do {
            try{
                String idJugador = JOptionPane.showInputDialog("Ingrese el id del jugador a borrar");
                EquipoDAO.buscarJugador(idJugador);

            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        while(!continuar);

    }

    public static Jugador modificarJugador() {
        boolean continuar = false;
        Jugador j=null;
        do {
            try {
                String idJugador = JOptionPane.showInputDialog("Introduzca el id del jugador a modificar");
                Jugador jugadorM = EquipoDAO.buscarJugador(idJugador);
                String nombre = solicitarDato("Nombre", "Teclea el nombre del jugador", "^[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ\\s]*$");
                String apellido = solicitarDato("Apellido","Teclea el apellido del jugador","^[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ\\s]*$");
                String nacionalidad = solicitarDato("Nacionalidad","Teclea la nacionalidad del jugador","^[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ]*$");
                LocalDate fechaNacimiento = solicitarFecha();
                String nickname = solicitarDato("Nickname","Teclea el nickname del jugador","^[a-zA-Z0-9_]{4,}$");
                String rol = solicitarDato("Rol","Teclea el rol del jugador","^[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ\\s]{3,}$");
                Double sueldo = Double.valueOf(solicitarDato("Sueldo", "Tecle el sueldo del jugador", "^[0-9]{5}$"));
                String idEquipo = solicitarDato("ID", "Teclea el ID del equipo al que pertenece", "^[A-Z]{1}[0-9]{3}$");
                Equipo equipo = EquipoDAO.buscarEquipo(idEquipo);
                j = new Jugador(idJugador, nombre, apellido, nacionalidad, fechaNacimiento, nickname, rol, sueldo, equipo);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al modificar el jugador");
            }
        } while (continuar);
        return j;
    }


}
