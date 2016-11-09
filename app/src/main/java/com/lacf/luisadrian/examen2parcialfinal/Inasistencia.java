package com.lacf.luisadrian.examen2parcialfinal;

/**
 * Creado por LuisAdrian el 07/11/2016.
 */

public class Inasistencia {

    private int id;
    private String fecha;
    private int alumno;

    public Inasistencia(String fecha, int alumno) {
        this.fecha = fecha;
        this.alumno = alumno;
    }

    public Inasistencia(int id, String fecha, int alumno) {
        this.id = id;
        this.fecha = fecha;
        this.alumno = alumno;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getAlumno() {
        return alumno;
    }

    public void setAlumno(int alumno) {
        this.alumno = alumno;
    }
}
