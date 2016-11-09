package com.lacf.luisadrian.examen2parcialfinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

public class DetallesAlumno extends AppCompatActivity {

    private int id;
    private TextView lblId, lblNombre, lblGrado, lblGrupo;
    private AlumnoController alumnoController;
    private AsistenciaController asistenciaController;
    private AdapterInasistenciasAlumno adapterInasistenciasAlumno;
    private RecyclerView rcvInasistencias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_alumno);
        Bundle bundle = getIntent().getExtras();

        id = bundle.getInt("id");

        alumnoController = new AlumnoController(this, "admin", null, 1);
        asistenciaController = new AsistenciaController(this, "admin", null, 1);

        adapterInasistenciasAlumno = new AdapterInasistenciasAlumno(this);

        rcvInasistencias = (RecyclerView) findViewById(R.id.rcv_inasistencias);
        rcvInasistencias.setAdapter(adapterInasistenciasAlumno);
        rcvInasistencias.setLayoutManager(new LinearLayoutManager(this));

        Alumno alumno = alumnoController.buscar(id);

        lblId = (TextView) findViewById(R.id.lbl_detalle_alumno_id);
        lblNombre = (TextView) findViewById(R.id.lbl_detalle_alumno_nombre);
        lblGrado = (TextView) findViewById(R.id.lbl_detalle_alumno_grado);
        lblGrupo = (TextView) findViewById(R.id.lbl_detalle_alumno_grupo);
        lblId.setText(alumno.getId() + "");
        lblNombre.setText(alumno.getNombre());
        lblGrado.setText(alumno.getGrado());
        lblGrupo.setText(alumno.getGrupo());

        adapterInasistenciasAlumno.setInasistencias(asistenciaController.inasistenciasAlumno(id));
    }
}
