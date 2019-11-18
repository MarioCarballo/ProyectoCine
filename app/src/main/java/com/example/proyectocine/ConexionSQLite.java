package com.example.proyectocine;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

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
        db.execSQL("create table usuarios (identificacion integer not null primary key, nombre text, apellido text,correo text, contrasena text)");

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




    public boolean consultaNombre(Dto datos) {
        boolean estado = true;
        int resultado;
        SQLiteDatabase bd = this.getReadableDatabase();
        try {
            String Nombre = datos.getNombre();
            Cursor fila = bd.rawQuery("select nombre, apellido, identificacion ,correo,contrasena from usuarios where nombre='" + consultaNombre(datos) + "'", null);
            if (fila.moveToFirst()) {
                datos.setNombre(fila.getString(0));
                datos.setApellido(fila.getString(1));
                datos.setIdentificacion(fila.getString(2));
                datos.setCorreo(fila.getString(2));
                estado = true;
            } else {
                estado = false;
            }
            fila.close();

        } catch (Exception e) {
            estado = false;
            Log.e("error.", e.toString());
        }
        return estado;
    }
    public boolean InsertarTradicional(Dto datos) {
        boolean estado = true;
        int resultado;

        try {
            String nombre = datos.getNombre();
            String apellido = datos.getApellido();
            String identificacion=datos.getIdentificacion();
            String correo=datos.getCorreo();
            String contrasena=datos.getContra1();


            Cursor fila = bd().rawQuery("select identificacion from usuarios where identificacion='" + datos.getIdentificacion() + "'", null);
            if (fila.moveToFirst() == true) {
                estado = false;
            } else {
                String SQL = "INSERT INTO usuarios \n" +
                        "(nombre,apellido,identificacion,correo,contrasena )\n" +
                        "VALUES \n" +

                        "('" + nombre + "', '" + apellido+ "', '" + identificacion + "','"+ correo +"','" + contrasena+ "');";

                bd().execSQL(SQL);
                bd().close();
                estado = true;
            }
        } catch (Exception e) {
            estado = false;
            Log.e("error", e.toString());
        }
        return estado;
    }
    public ArrayList<String> obtenerUsuarios () {
        ArrayList<String> listaUsuarios = new ArrayList<String>();
        final boolean add = listaUsuarios.add("Seleccione");

        for (int i = 0; i < usuarioslist.size(); i++) {
            listausuarios.add(usuarioslist.get(i).getNombre() + "~" + usuarioslist.get(i).getApellido() + "~" + usuarioslist.get(i).getIdentificacion()
            + "~"+ usuarioslist.get(i).getCorreo()+"~"  + usuarioslist.get(i).getContra1());
        }
        return listaUsuarios;
    }
    public boolean modificar (Dto datos){
        boolean estado = true;
        int resultado;
        SQLiteDatabase bd = this.getWritableDatabase();
        try{

            String nombre = datos.getNombre();
            String  apellido=datos.getApellido();
            String identificacion=datos.getIdentificacion();
            String correo=datos.getCorreo();
            String contrasena=datos.getContra1();


            ContentValues registro = new ContentValues();
            registro.put("nombre", nombre);
            registro.put("apellido", apellido);
            registro.put("identificacion", identificacion);
            registro.put("correo" ,correo);
            registro.put("contrasena", contrasena);

            int cant = (int) bd.update("usuarios", registro, "identificacion=" + identificacion, null);

            bd.close();
            if (cant>0) estado = true;
            else estado = false;
        }catch (Exception e){
            estado = false;
            Log.e("error.", e.toString());
        }
        return estado;
    }

}
