package com.lacf.luisadrian.examen2parcialfinal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

import java.util.ArrayList;

/**
 * Creado por LuisAdrian el 07/11/2016.
 */

public class AlumnoController {

    private SQLTomaAsistencia sqlTomaAsistencia;
    private final static String table = "tb_alumnos";

    public AlumnoController(Context context, String name, CursorFactory cursorFactory, Integer version) {
        this.sqlTomaAsistencia = new SQLTomaAsistencia(context, name, cursorFactory, version);
    }

    public boolean agregar(Alumno nuevo) {
        SQLiteDatabase database = sqlTomaAsistencia.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("al_nombre", nuevo.getNombre());
        contentValues.put("al_grado", nuevo.getGrado());
        contentValues.put("al_grupo", nuevo.getGrupo());
        long key = database.insert(table, null, contentValues);
        database.close();
        return (key > -1);
    }

    public ArrayList<Alumno> buscar(String grado, String grupo) {
        ArrayList<Alumno> alumnos = new ArrayList<>();
        SQLiteDatabase database = sqlTomaAsistencia.getReadableDatabase();
        Cursor cursorAlumnos = database.query(table, null, "al_grado = ? and al_grupo = ?", new String[] {grado, grupo}, null, null, null);
        while (cursorAlumnos.moveToNext()) {
            Alumno buscado = new Alumno(cursorAlumnos.getInt(0), cursorAlumnos.getString(1), cursorAlumnos.getString(2), cursorAlumnos.getString(3));
            alumnos.add(buscado);
        }
        cursorAlumnos.close();
        return alumnos;
    }

    public Alumno buscar(Integer id) {
        SQLiteDatabase database = sqlTomaAsistencia.getReadableDatabase();
        Cursor cursorAlumnos = database.query(table, null, "al_id = ?", new String[] {id + ""}, null, null, null);
        Alumno buscado = null;
        while (cursorAlumnos.moveToNext()) {
            buscado = new Alumno(cursorAlumnos.getInt(0), cursorAlumnos.getString(1), cursorAlumnos.getString(2), cursorAlumnos.getString(3));
        }
        return buscado;
    }
}
