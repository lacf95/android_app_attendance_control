package com.lacf.luisadrian.examen2parcialfinal;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Creado por LuisAdrian el 07/11/2016.
 */

public class AdapterAlumnos extends RecyclerView.Adapter<AdapterAlumnos.ViewHolderAlumnos>{

    private ArrayList<Alumno> alumnos = new ArrayList<>();
    private LayoutInflater layoutInflater;

    public AdapterAlumnos(Context context) {
        layoutInflater = LayoutInflater.from(context);
    }

    public void setAlumnos(ArrayList<Alumno> alumnos) {
        this.alumnos = alumnos;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolderAlumnos onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.alumnos_template, parent, false);
        ViewHolderAlumnos viewHolderAlumnos = new ViewHolderAlumnos(view);
        return viewHolderAlumnos;
    }

    @Override
    public void onBindViewHolder(final ViewHolderAlumnos holder, int position) {
        final Integer pos = position;
        final Alumno current = alumnos.get(position);
        holder.lblShowId.setText(current.getId()+"");
        holder.lblShowNombre.setText(current.getNombre());
        holder.lyoAlumnosTemplate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.context, DetallesAlumno.class);
                intent.putExtra("id", alumnos.get(pos).getId());
                holder.context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return alumnos.size();
    }

    static class ViewHolderAlumnos extends RecyclerView.ViewHolder {

        LinearLayout lyoAlumnosTemplate;
        TextView lblShowNombre, lblShowId;
        Context context;

        public ViewHolderAlumnos(View itemView) {
            super(itemView);
            lyoAlumnosTemplate = (LinearLayout) itemView.findViewById(R.id.lyo_alumnos_template);
            lblShowNombre = (TextView) itemView.findViewById(R.id.lbl_alumno_show_nombre);
            lblShowId = (TextView) itemView.findViewById(R.id.lbl_alumno_show_id);
            context = itemView.getContext();
        }
    }
}