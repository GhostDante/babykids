package com.example.dante.babykids;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dante.babykids.fragments.InicioFragment;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    private DataBase db;
    private SQLiteDatabase conexion;
    private EditText etu,etp;
    private ArrayList<Ninera> nineras;


    //Metodo que ejecuta el layout de login y obtiene la conexion a la DB
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db = new DataBase(this);
       conexion = db.getWritableDatabase();
        etu = (EditText) findViewById(R.id.etu);
        etp = (EditText) findViewById(R.id.etp);
        nineras = new ArrayList<Ninera>();
    }

    //Metodo para validar usuario y contraseña en la base de datos
    public void validarUsuario(View view){

        Fragment fragment = null;

        Boolean encontrado =false;
        Cursor miCursor = conexion.rawQuery("SELECT usuario,contra from usuarios",null);
        while (miCursor.moveToNext() && encontrado ==false)
        {
            String usuario = miCursor.getString(miCursor.getColumnIndex("usuario"));
            String contra = miCursor.getString(miCursor.getColumnIndex("contra"));

            if(usuario.equalsIgnoreCase(etu.getText().toString()))
            {
                if (contra.equals(etp.getText().toString()))
                {
                    encontrado=true;

                    miCursor.close();
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(getApplicationContext(),"Contraseña incorrecta",Toast.LENGTH_SHORT).show();
                }
            }else {
                Toast.makeText(getApplicationContext(), "Usario y/o contraseña incorrectos", Toast.LENGTH_SHORT).show();
            }
        }
    }


}
