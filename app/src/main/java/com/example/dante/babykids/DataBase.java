package com.example.dante.babykids;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DataBase extends SQLiteOpenHelper {

    private final static String NOMBRE_DB="baby.db";
    private final static int VERSION_DB=1;
    private final static String TABLA_BABY="CREATE TABLE nanas(id integer  primary key AUTOINCREMENT ,nombre text,edad integer,telefono text,dias text,horas text)";
    private final static String TABLA_USUARIOS="CREATE TABLE usuarios(id integer  primary key AUTOINCREMENT ,usuario text,contra text)";
    public DataBase(Context context) {
        super(context, NOMBRE_DB, null, VERSION_DB);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(TABLA_BABY);
        db.execSQL(TABLA_USUARIOS);
        ContentValues values = new ContentValues();
        values.put("Usuario","admin");
        values.put("contra","admin");
        db.insert("usuarios",null,values);

        ContentValues values2 = new ContentValues();
        values2.put("nombre","Sara");
        values2.put("edad","23");
        values2.put("telefono","73523564");
        values2.put("dias","L,M,M,J,V,S,D");
        values2.put("horas","2:00PM-12:00PM");
        db.insert("nanas",null,values2);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS nanas");
        db.execSQL("DROP TABLE IF EXISTS usuarios");
        db.execSQL(TABLA_BABY);
        db.execSQL(TABLA_USUARIOS);
    }
}
