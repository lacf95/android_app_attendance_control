package com.lacf.luisadrian.examen2parcialfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Principal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        Button btnShowAgregar = (Button) findViewById(R.id.btn_show_alumno_add);
        btnShowAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAgregarAlumno();
            }
        });

        Button btnShowLista = (Button) findViewById(R.id.btn_show_grupos);
        btnShowLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMostrarLista();
            }
        });

        Button btnShowTomaAsistencia = (Button) findViewById(R.id.btn_show_asistencia);
        btnShowTomaAsistencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTomarAsistencia();
            }
        });
    }

    private void showTomarAsistencia() {
        Intent intent = new Intent(this, TomarAsistencia.class);
        startActivity(intent);
    }

    public void showAgregarAlumno() {
        Intent intent = new Intent(this, AgregarAlumno.class);
        startActivity(intent);
    }

    public void showMostrarLista() {
        Intent intent = new Intent(this, ListaAsistencia.class);
        startActivity(intent);
    }
}
