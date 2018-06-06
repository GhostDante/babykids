package com.example.dante.babykids;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

//Clase adapter para la recoleccion de los datos de la ninera
public class ListaAdapter extends RecyclerView.Adapter<ListaAdapter.AdapterViewHolder> {
    private List<Ninera> items;

    //Clase con conexion al layout y los cardView
    public static class AdapterViewHolder extends RecyclerView.ViewHolder
    {
        public View v;
        public Context c;
        private TextView nombre,edad,telefono,horas,dias;

        public AdapterViewHolder(View v)
        {
            super(v);
            c = v.getContext();
            nombre = v.findViewById(R.id.tvNombre);
            edad = v.findViewById(R.id.tvEdad);
            telefono = v.findViewById(R.id.tvTelefono);
            dias = v.findViewById(R.id.tvDias);
            horas = v.findViewById(R.id.tvHoras);
            this.v = v;
        }
    }

    public ListaAdapter (List<Ninera> items){
        this.items = items;
    }

    public int getItemCount(){
        return items.size();
    }

    //conexion al cardView
    public AdapterViewHolder onCreateViewHolder(ViewGroup vg, int i)
    {
        View v = LayoutInflater.from(vg.getContext()).inflate(R.layout.item_nana,vg,false);
        return new AdapterViewHolder(v);
    }


    //obtiene los datos del adapter y los agrega a los objetos creados en el layout y el cardView
    public void onBindViewHolder(final AdapterViewHolder vh, final int i) {
        vh.nombre.setText(items.get(i).getNombre());
        vh.edad.setText(items.get(i).getEdad());
        vh.telefono.setText(items.get(i).getTelefono());
        vh.dias.setText(items.get(i).getDias());
        vh.horas.setText(items.get(i).getHoras());
    }

}
