package Modelo;

import java.time.LocalDate;

public class Campeonato {
    private String ID;
    private String Nombre;
    private LocalDate Fecha_inicio;

    public Campeonato(String ID, String nombre, LocalDate fecha_inicio) {
        this.ID = ID;
        Nombre = nombre;
        Fecha_inicio = fecha_inicio;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public LocalDate getFecha_inicio() {
        return Fecha_inicio;
    }

    public void setFecha_inicio(LocalDate fecha_inicio) {
        Fecha_inicio = fecha_inicio;
    }
}
