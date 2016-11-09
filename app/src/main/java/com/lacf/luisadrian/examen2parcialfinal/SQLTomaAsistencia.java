package com.lacf.luisadrian.examen2parcialfinal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Creado por LuisAdrian el 07/11/2016.
 */

public class SQLTomaAsistencia extends SQLiteOpenHelper {

    public SQLTomaAsistencia(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE tb_alumnos(al_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, al_nombre TEXT, al_grado TEXT, al_grupo TEXT)");
        db.execSQL("CREATE TABLE tb_inasistencias(in_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, in_fecha DATE, in_alumno INTEGER, FOREIGN KEY(in_alumno) REFERENCES tb_alumnos(al_id))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS tb_inasistencias");
        db.execSQL("DROP TABLE IF EXISTS tb_alumnos");
        db.execSQL("CREATE TABLE tb_alumnos(al_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, al_nombre TEXT, al_grado TEXT, al_grupo TEXT)");
        db.execSQL("CREATE TABLE tb_inasistencias(in_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, in_fecha DATE, in_alumno INTEGER, FOREIGN KEY(in_alumno) REFERENCES tb_alumnos(al_id))");
    }
}
