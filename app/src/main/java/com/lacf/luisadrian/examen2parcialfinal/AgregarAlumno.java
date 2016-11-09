package com.lacf.luisadrian.examen2parcialfinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AgregarAlumno extends AppCompatActivity {

    EditText txtNombre, txtGrado, txtGrupo;
    AlumnoController alumnoController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_alumno);
        txtNombre = (EditText) findViewById(R.id.txt_alumno_add_nombre);
        txtGrado = (EditText) findViewById(R.id.txt_alumno_add_grado);
        txtGrupo = (EditText) findViewById(R.id.txt_alumno_add_grupo);
        Button btn = (Button) findViewById(R.id.btn_alumno_add);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarAlumno();
            }
        });
        alumnoController = new AlumnoController(this, "admin", null, 1);
    }

    public void guardarAlumno() {
        String nombre = txtNombre.getText().toString();
        String grado = txtGrado.getText().toString();
        String grupo = txtGrupo.getText().toString();

        String mensaje = (alumnoController.agregar(new Alumno(nombre, grado, grupo))) ? "Guardado": "Error";
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }
}
