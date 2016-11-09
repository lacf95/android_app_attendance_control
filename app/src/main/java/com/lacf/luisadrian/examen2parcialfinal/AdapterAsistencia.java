package com.lacf.luisadrian.examen2parcialfinal;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Creado por LuisAdrian el 08/11/2016.
 */

public class AdapterAsistencia extends RecyclerView.Adapter<AdapterAsistencia.ViewHolderAsistencia> {

    private ArrayList<Alumno> alumnos = new ArrayList<>();
    private LayoutInflater layoutInflater;

    public AdapterAsistencia(Context context) {
        layoutInflater = LayoutInflater.from(context);
    }

    public void setAlumnos(ArrayList<Alumno> alumnos) {
        this.alumnos = alumnos;
        notifyDataSetChanged();
    }

    public ArrayList<Alumno> getAlumnos() {
        return alumnos;
    }

    public ArrayList<Integer> getSeleccionados() {
        ArrayList<Integer> seleccionados = new ArrayList<>();
        for (Alumno alumno: alumnos) {
            if (alumno.isSelected())
                seleccionados.add(alumno.getId());
        }
        return seleccionados;
    }

    @Override
    public ViewHolderAsistencia onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.inasistencia_template, parent, false);
        ViewHolderAsistencia viewHolderAsistencia = new ViewHolderAsistencia(view);
        return viewHolderAsistencia;
    }

    @Override
    public void onBindViewHolder(ViewHolderAsistencia holder, int position) {
        final int pos = position;
        Alumno current = alumnos.get(position);
        holder.lblNombre.setText(current.getNombre());
        holder.lblId.setText(current.getId()+"");
        holder.ckbFalta.setChecked(current.isSelected());
        holder.ckbFalta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox ckb = (CheckBox) v.findViewById(R.id.ckb_asistencia_falta);
                TextView lblNombre = (TextView) v.findViewById(R.id.lbl_asistencia_nombre);
                alumnos.get(pos).setSelected(ckb.isChecked());
            }
        });
    }

    @Override
    public int getItemCount() {
        return alumnos.size();
    }

    static class ViewHolderAsistencia extends RecyclerView.ViewHolder {

        public TextView lblNombre, lblId;
        public CheckBox ckbFalta;
        public Alumno singleAlumno;

        public ViewHolderAsistencia(View itemView) {
            super(itemView);
            lblNombre = (TextView) itemView.findViewById(R.id.lbl_asistencia_nombre);
            lblId = (TextView) itemView.findViewById(R.id.lbl_asistencia_id);
            ckbFalta = (CheckBox) itemView.findViewById(R.id.ckb_asistencia_falta);
        }
    }
}
