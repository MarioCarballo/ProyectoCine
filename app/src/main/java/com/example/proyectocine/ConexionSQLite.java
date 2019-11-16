package com.example.proyectocine;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class ConexionSQLite extends SQLiteOpenHelper {
    ArrayList<String> listausuarios;
    ArrayList<Dto> usuarioslist;
    boolean estadoDelete = true;


    public ConexionSQLite(Context context) {
        super(context, "administracion.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table usuarios (codigo integer not null primary key, nombre text, apellido tex,correo text, contraseña text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists usuarios");
        onCreate(db);
    }

    public SQLiteDatabase bd() {
        SQLiteDatabase bd = this.getWritableDatabase();
        return bd;
    }
}
