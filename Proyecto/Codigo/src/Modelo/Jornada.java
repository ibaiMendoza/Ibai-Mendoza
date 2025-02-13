package Modelo;

import java.util.ArrayList;

public class Jornada {
    private String idJornada;
    private String fecha;
    private ArrayList <Enfrentamiento> listaEnfrentamientos;

    public Jornada() {
    }

    public Jornada(ArrayList<Enfrentamiento> listaEnfrentamientos, String fecha, String idJornada) {
        this.listaEnfrentamientos = listaEnfrentamientos;
        this.fecha = fecha;
        this.idJornada = idJornada;
    }

    public String getIdJornada() {
        return idJornada;
    }

    public void setIdJornada(String idJornada) {
        this.idJornada = idJornada;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public ArrayList<Enfrentamiento> getListaEnfrentamientos() {
        return listaEnfrentamientos;
    }

    public void setListaEnfrentamientos(ArrayList<Enfrentamiento> listaEnfrentamientos) {
        this.listaEnfrentamientos = listaEnfrentamientos;
    }
}