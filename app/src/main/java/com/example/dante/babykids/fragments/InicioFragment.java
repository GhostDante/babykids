package com.example.dante.babykids.fragments;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.recyclerview.extensions.ListAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.dante.babykids.DataBase;
import com.example.dante.babykids.ListaAdapter;
import com.example.dante.babykids.Ninera;
import com.example.dante.babykids.R;

import java.util.ArrayList;
import java.util.List;


public class InicioFragment extends Fragment {
    private FragmentActivity myContext;
    private RecyclerView recycler;
    private ListaAdapter adapter;

    //bd
    private DataBase db;
    //conexion
    private SQLiteDatabase conexion;

    @Override
    public void onAttach(Activity activity) {
        myContext = (FragmentActivity) activity;
        super.onAttach(activity);
    }


    //Metodo que ejecuta el layout y crea en la clase ninera el objeto con sus respectivos datos
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_inicio_fragment, container, false);

        List<Ninera> lista = new ArrayList<Ninera>();
        db = new DataBase(myContext);
        conexion = db.getWritableDatabase();

        // Obtener el Recycler
        recycler = (RecyclerView) view.findViewById(R.id.reciclador);
        // Usar un administrador para LinearLayout
        recycler.setLayoutManager(new LinearLayoutManager(myContext));

        Cursor miCursor = conexion.rawQuery("SELECT nombre,edad,telefono,dias,horas from nanas", null);

        while (miCursor.moveToNext()) {
            String nombre = miCursor.getString(miCursor.getColumnIndex("nombre"));
            String edad = miCursor.getString(miCursor.getColumnIndex("edad"));
            String telefono = miCursor.getString(miCursor.getColumnIndex("telefono"));
            String dias = miCursor.getString(miCursor.getColumnIndex("dias"));
            String horas = miCursor.getString(miCursor.getColumnIndex("horas"));

            Ninera nueva = new Ninera(nombre, dias, horas, edad, telefono);

            Log.i("nineraaa",nombre);
            lista.add(nueva);
        }

        adapter = new ListaAdapter(lista);
        recycler.setAdapter(adapter);

        return view;
    }


}
