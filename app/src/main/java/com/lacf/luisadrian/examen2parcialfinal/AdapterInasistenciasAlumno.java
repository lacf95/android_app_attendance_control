package com.lacf.luisadrian.examen2parcialfinal;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Creado por LuisAdrian el 08/11/2016.
 */

public class AdapterInasistenciasAlumno extends RecyclerView.Adapter<AdapterInasistenciasAlumno.ViewHolderInasistenciaAlumno> {

    private ArrayList<Inasistencia> inasistencias = new ArrayList<>();
    private LayoutInflater layoutInflater;

    public AdapterInasistenciasAlumno(Context context) {
        layoutInflater = LayoutInflater.from(context);
    }

    public void setInasistencias(ArrayList<Inasistencia> inasistencias) {
        this.inasistencias = inasistencias;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolderInasistenciaAlumno onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.inasistencia_alumno_template, parent, false);
        ViewHolderInasistenciaAlumno viewHolderInasistenciaAlumno = new ViewHolderInasistenciaAlumno(view);
        return viewHolderInasistenciaAlumno;
    }

    @Override
    public void onBindViewHolder(ViewHolderInasistenciaAlumno holder, int position) {
        Inasistencia current = inasistencias.get(position);
        holder.lblFecha.setText(current.getFecha());
        holder.lblAlumno.setText(current.getAlumno()+"");
    }

    @Override
    public int getItemCount() {
        return inasistencias.size();
    }

    static class ViewHolderInasistenciaAlumno extends RecyclerView.ViewHolder {

        public TextView lblFecha, lblAlumno;

        public ViewHolderInasistenciaAlumno(View itemView) {
            super(itemView);
            lblFecha = (TextView) itemView.findViewById(R.id.lbl_inasistencia_fecha);
            lblAlumno = (TextView) itemView.findViewById(R.id.lbl_inasistencia_alumno);
        }
    }
}
