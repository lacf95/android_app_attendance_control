package com.lacf.luisadrian.examen2parcialfinal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Creado por LuisAdrian el 08/11/2016.
 */

public class AsistenciaController {

    private SQLTomaAsistencia sqlTomaAsistencia;
    private final static String table = "tb_inasistencias";

    public AsistenciaController(Context context, String name, SQLiteDatabase.CursorFactory cursorFactory, Integer version) {
        this.sqlTomaAsistencia = new SQLTomaAsistencia(context, name, cursorFactory, version);
    }

    public ArrayList<Inasistencia> buscar() {
        ArrayList<Inasistencia> inasistencias = new ArrayList<>();
        SQLiteDatabase database = sqlTomaAsistencia.getReadableDatabase();
        Cursor cursorInasistencia = database.query(table, null, null, null, null, null, null);
        while (cursorInasistencia.moveToNext()) {
            Inasistencia inasistencia = new Inasistencia(cursorInasistencia.getInt(0), cursorInasistencia.getString(1), cursorInasistencia.getInt(2));
            inasistencias.add(inasistencia);
        }
        cursorInasistencia.close();
        return inasistencias;
    }

    public void agregarInasistencia(ArrayList<Integer> alumnos, String fecha) {
        SQLiteDatabase database = sqlTomaAsistencia.getWritableDatabase();
        String sqlScript = "INSERT INTO tb_inasistencias(in_fecha, in_alumno) VALUES";
        for (int i = 0; i < alumnos.size(); i++) {
            sqlScript += " ('"+ fecha +"', " + alumnos.get(i) + ")";
            if (i < alumnos.size() - 1)
                sqlScript += ",";
        }
        database.execSQL(sqlScript);
    }

    public void eliminarInasistencias() {
        SQLiteDatabase database = sqlTomaAsistencia.getWritableDatabase();
        database.delete(table, null, null);
    }

    public ArrayList<Inasistencia> totalInasistencias(String grado, String grupo, String fechaInicio, String fechaFin) {
        if (grupo == null)
            grupo = "";
        if (grado == null)
            grado = "";
        if (fechaInicio == null)
            fechaInicio = "";
        if (fechaFin == null)
            fechaFin = "";
        ArrayList<Inasistencia> inasistencias = new ArrayList<>();
        SQLiteDatabase database = sqlTomaAsistencia.getReadableDatabase();
        String query = "select a.* from tb_inasistencias a left join tb_alumnos a on a.in_alumno = a.al_id where a.in_fecha between '"+fechaInicio+"' and '"+fechaFin+"' and a.al_grado = '"+grado+"' and a.al_grupo = '"+grupo+"'";
        Cursor cursorInasistencia = database.rawQuery(query, null);
        while (cursorInasistencia.moveToNext()) {
            Inasistencia inasistencia = new Inasistencia(cursorInasistencia.getInt(0), cursorInasistencia.getString(1), cursorInasistencia.getInt(2));
            inasistencias.add(inasistencia);
        }
        cursorInasistencia.close();
        return inasistencias;
    }

    public ArrayList<Inasistencia> inasistenciasAlumno(Integer id) {
        ArrayList<Inasistencia> inasistencias = new ArrayList<>();
        SQLiteDatabase database = sqlTomaAsistencia.getReadableDatabase();
        Cursor cursorInasistencia = database.query(table, null, "in_alumno = ?", new String[] {id+""}, null, null, null);
        while (cursorInasistencia.moveToNext()) {
            Inasistencia inasistencia = new Inasistencia(cursorInasistencia.getInt(0), cursorInasistencia.getString(1), cursorInasistencia.getInt(2));
            inasistencias.add(inasistencia);
        }
        cursorInasistencia.close();
        return inasistencias;
    }
}
