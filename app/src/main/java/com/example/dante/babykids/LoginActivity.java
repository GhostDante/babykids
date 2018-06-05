package com.example.dante.babykids;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private DataBase db;
    private SQLiteDatabase conexion;
    private EditText etu,etp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db = new DataBase(this);
       conexion = db.getWritableDatabase();
        etu = (EditText) findViewById(R.id.etu);
        etp = (EditText) findViewById(R.id.etp);
    }


    public void validarUsuario(View view){

        Boolean encontrado =false;
        Cursor miCursor = conexion.rawQuery("SELECT usuario,contra from usuarios",null);
        while (miCursor.moveToNext() && encontrado ==false){
            String usuario = miCursor.getString(miCursor.getColumnIndex("usuario"));
            String contra = miCursor.getString(miCursor.getColumnIndex("contra"));
            if(usuario.equalsIgnoreCase(etu.getText().toString())){
                if (contra.equals(etp.getText().toString())){
                    Intent i = new Intent(this, MainActivity.class);
                    startActivity(i);

                }else{
                    Toast.makeText(getApplicationContext(),"Contraseña incorrecta",Toast.LENGTH_SHORT).show();
                }
            }else {
                Toast.makeText(getApplicationContext(), "Usario y/o contraseña incorrectos", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
