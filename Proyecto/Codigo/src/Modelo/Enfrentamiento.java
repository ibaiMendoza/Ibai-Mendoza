package Modelo;

public class Enfrentamiento {
    private String id_enfrentamiento;
    private String fecha_enfrentamiento;
    private String hora_enfrentamiento;
    private Equipo[] listaEquipos;
    private Jornada jornada;
    private Equipo EquipoGanador;
    private int[] puntuaciones;

    public Enfrentamiento() {

    }

    public Enfrentamiento(String id_enfrentamiento, String fecha_enfrentamiento, String hora_enfrentamiento, Equipo[] listaEquipos, Jornada jornada, Equipo equipoGanador, int[] puntuaciones) {
        this.id_enfrentamiento = id_enfrentamiento;
        this.fecha_enfrentamiento = fecha_enfrentamiento;
        this.hora_enfrentamiento = hora_enfrentamiento;
        this.listaEquipos = listaEquipos;
        this.jornada = jornada;
        EquipoGanador = equipoGanador;
        this.puntuaciones = puntuaciones;
    }

    public String getId_enfrentamiento() {
        return id_enfrentamiento;
    }

    public void setId_enfrentamiento(String id_enfrentamiento) {
        this.id_enfrentamiento = id_enfrentamiento;
    }

    public String getFecha_enfrentamiento() {
        return fecha_enfrentamiento;
    }

    public void setFecha_enfrentamiento(String fecha_enfrentamiento) {
        this.fecha_enfrentamiento = fecha_enfrentamiento;
    }

    public String getHora_enfrentamiento() {
        return hora_enfrentamiento;
    }

    public void setHora_enfrentamiento(String hora_enfrentamiento) {
        this.hora_enfrentamiento = hora_enfrentamiento;
    }

    public Equipo[] getListaEquipos() {
        return listaEquipos;
    }

    public void setListaEquipos(Equipo[] listaEquipos) {
        this.listaEquipos = listaEquipos;
    }

    public Jornada getJornada() {
        return jornada;
    }

    public void setJornada(Jornada jornada) {
        this.jornada = jornada;
    }

    public Equipo getEquipoGanador() {
        return EquipoGanador;
    }

    public void setEquipoGanador(Equipo equipoGanador) {
        EquipoGanador = equipoGanador;
    }

    public int[] getPuntuaciones() {
        return puntuaciones;
    }

    public void setPuntuaciones(int[] puntuaciones) {
        this.puntuaciones = puntuaciones;
    }
}