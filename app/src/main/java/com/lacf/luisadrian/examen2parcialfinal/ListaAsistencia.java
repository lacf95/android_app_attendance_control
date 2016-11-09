package com.lacf.luisadrian.examen2parcialfinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class ListaAsistencia extends AppCompatActivity {

    AdapterAlumnos adapterAlumnos;
    AdapterInasistenciasAlumno adapterInasistenciasAlumno;
    AlumnoController alumnoController;
    AsistenciaController asistenciaController;
    RecyclerView rcvGrupoAlumnos;
    RecyclerView rcvGrupoInasistencia;
    EditText txtGrado, txtGrupo, txtFechaInicio, txtFechaFin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_asistencia);

        adapterAlumnos = new AdapterAlumnos(this);
        rcvGrupoAlumnos = (RecyclerView) findViewById(R.id.rcv_grupo_alumnos);
        rcvGrupoAlumnos.setLayoutManager(new LinearLayoutManager(this));
        rcvGrupoAlumnos.setAdapter(adapterAlumnos);

        adapterInasistenciasAlumno = new AdapterInasistenciasAlumno(this);
        rcvGrupoInasistencia = (RecyclerView) findViewById(R.id.rcv_grupo_asistencia);
        rcvGrupoInasistencia.setLayoutManager(new LinearLayoutManager(this));
        rcvGrupoInasistencia.setAdapter(adapterInasistenciasAlumno);

        alumnoController = new AlumnoController(this, "admin", null, 1);
        asistenciaController = new AsistenciaController(this, "admin", null, 1);

        txtGrado = (EditText) findViewById(R.id.txt_grado_search);
        txtGrupo = (EditText) findViewById(R.id.txt_grupo_search);
        txtFechaInicio = (EditText) findViewById(R.id.txt_fechaInicio_search);
        txtFechaFin = (EditText) findViewById(R.id.txt_fechaFin_search);
        Button btnBuscar = (Button) findViewById(R.id.btn_search_grupo);
        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buscarGrupo();
            }
        });
    }

    public void buscarGrupo() {
        String grado = txtGrado.getText().toString();
        String grupo = txtGrupo.getText().toString();
        String fechaInicio = txtFechaInicio.getText().toString();
        String fechaFin = txtFechaFin.getText().toString();
        adapterAlumnos.setAlumnos(alumnoController.buscar(grado, grupo));
        ArrayList<Inasistencia> inasistencias = asistenciaController.totalInasistencias(grado, grupo, fechaInicio, fechaFin);
        adapterInasistenciasAlumno.setInasistencias(inasistencias);
        TextView lblTotal = (TextView) findViewById(R.id.lbl_faltas_search);
        lblTotal.setText(inasistencias.size()+"");
    }
}
