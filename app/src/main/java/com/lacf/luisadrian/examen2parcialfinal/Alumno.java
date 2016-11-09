package com.lacf.luisadrian.examen2parcialfinal;

/**
 * Creado por LuisAdrian el 07/11/2016.
 */

public class Alumno {

    private int id;
    private String nombre;
    private String grado;
    private String grupo;
    private boolean selected;

    public Alumno(String nombre, String grado, String grupo) {
        this.nombre = nombre;
        this.grado = grado;
        this.grupo = grupo;
        selected = false;
    }

    public Alumno(int id, String nombre, String grado, String grupo) {
        this.id = id;
        this.nombre = nombre;
        this.grado = grado;
        this.grupo = grupo;
        selected = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
