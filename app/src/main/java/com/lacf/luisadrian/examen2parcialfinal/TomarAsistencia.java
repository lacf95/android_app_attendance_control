package com.lacf.luisadrian.examen2parcialfinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class TomarAsistencia extends AppCompatActivity {

    AdapterAsistencia adapterAsistencia;
    AlumnoController alumnoController;
    AsistenciaController asistenciaController;
    RecyclerView rcvAsistencia;
    EditText txtGrado, txtGrupo, txtFecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tomar_asistencia);

        txtGrado = (EditText) findViewById(R.id.txt_asistencia_grado);
        txtGrupo = (EditText) findViewById(R.id.txt_asistencia_grupo);
        rcvAsistencia = (RecyclerView) findViewById(R.id.rcv_asistencia);
        rcvAsistencia.setLayoutManager(new LinearLayoutManager(this));
        adapterAsistencia = new AdapterAsistencia(this);
        alumnoController = new AlumnoController(this, "admin", null, 1);
        asistenciaController = new AsistenciaController(this, "admin", null, 1);
        rcvAsistencia.setAdapter(adapterAsistencia);
        Button btnBuscar = (Button) findViewById(R.id.btn_search_asistencia);
        Button btnTomarAsistencia = (Button) findViewById(R.id.btn_toma_asistencia);
        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buscarGrupo();
            }
        });
        btnTomarAsistencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tomarAsistencia();
            }
        });
    }

    public void buscarGrupo() {
        String grado = txtGrado.getText().toString();
        String grupo = txtGrupo.getText().toString();
        adapterAsistencia.setAlumnos(alumnoController.buscar(grado, grupo));
    }

    public void tomarAsistencia() {
        EditText txtFecha = (EditText) findViewById(R.id.txt_asistencia_fecha);
        String fecha = txtFecha.getText().toString();
        ArrayList<Integer> alumnosId = adapterAsistencia.getSeleccionados();
        asistenciaController.agregarInasistencia(alumnosId, fecha);
        Toast.makeText(this, "Guardado", Toast.LENGTH_SHORT).show();
    }
}
