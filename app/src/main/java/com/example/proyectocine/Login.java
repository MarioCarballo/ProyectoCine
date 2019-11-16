package com.example.proyectocine;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    private Button btnBuscar, btnActualizar;
    private EditText et_nombre, et_apellido, et_identificacion, et_email, et_pass, et_pas2;

    boolean estadoNombre = false;
    boolean estadoApellido = false;
    boolean estadoIdentificacion = false;
    boolean estadoEmail = false;
    boolean estadoClave = false;
    boolean estadoClave2 = false;
    int estadoInsert = 0;

    boolean inputEt = false;
    boolean InputEd = false;
    boolean inputEp = false;

    ConexionSQLite conexion = new ConexionSQLite(this);
    Usuario datos = new Usuario();
    AlertDialog.Builder dialogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnBuscar = (Button) findViewById(R.id.btnBuscar);
        btnActualizar = (Button) findViewById(R.id.btnActualizar);

        et_nombre = (EditText) findViewById(R.id.et_nombre);
        et_apellido = (EditText) findViewById(R.id.et_apellido);
        et_identificacion = (EditText) findViewById(R.id.et_identificacion);
        et_email = (EditText) findViewById(R.id.et_email);
        et_pass = (EditText) findViewById(R.id.et_pass);
        et_pas2 = (EditText) findViewById(R.id.et_pas2);


    }

    public void guardar(View v) {
        if (et_nombre.getText().toString().length() == 0) {
            estadoNombre = false;
            et_nombre.setError("Campo Obligatorio");
        } else {
            estadoNombre = true;
        }
        if (et_apellido.getText().toString().length() == 0) {
            estadoApellido = false;
            et_apellido.setError("Campo Obligatorio");
        } else {
            estadoApellido = true;
        }
        if (et_identificacion.getText().toString().length() == 0) {
            estadoIdentificacion = false;
            et_identificacion.setError("Campo Obligatorio");
        } else {
            estadoIdentificacion = true;
        }
        if (et_email.getText().toString().length() == 0) {
            estadoEmail = false;
            et_email.setError("Campo Obligatorio");
        } else {
            estadoEmail = true;
        }
        if (et_pass.getText().toString().length() == 0) {
            estadoClave = false;
            et_pass.setError("Campo Obligatorio");
        } else {
            estadoClave = true;
        }
        if (et_pas2.getText().toString().length() == 0) {
            estadoClave2 = false;
            et_pas2.setError("Campo Obligatorio");
        } else {
            estadoClave2 = true;
        }

     //   if (estadoCodigo && estadoDescripcion && estadoPrecio) {
       //     try {
         //       datos.setCodigo(Integer.parseInt(etcodigo.getText().toString()));
           //     datos.setDescripcion(etarticulo.getText().toString());
             //   datos.setPrecio(Double.parseDouble(etprecio.getText().toString()));
               /// if (conexion.InsertarTradicional(datos)){
                  //  Toast.makeText(this, "registro agregado satisfactoriamente!", Toast.LENGTH_SHORT).show();
                    //limpiarDatos();
                //}else {
                  //  Toast.makeText(MainActivity.this, "Error. Ya existe un registro\n"+ " Codigo: "
                    //        +etcodigo.getText().toString(), Toast.LENGTH_SHORT).show();
                    //limpiarDatos();
                //}

            //}catch (Exception e){
              //  Toast.makeText(this, "Error. Ya existe.", Toast.LENGTH_SHORT).show();
            //}
        //}
    }
    public void consultaNombre(View v) {
        if (et_nombre.getText().toString().length()==0){
            et_nombre.setError("Campo obligatorio");
            estadoNombre=false;
        }else {
            estadoNombre=true;
        }if (estadoNombre){
            String descripcion=et_nombre .getText().toString();
            datos.setNombre(descripcion);
        //    if (conexion.consultaNombre(datos)){
             //   etcodigo.setText(""+datos.getCodigo());
               // etarticulo.setText(datos.getDescripcion());
              //  etprecio.setText(""+datos.getPrecio());
           // }else {
               // Toast.makeText(this,"No existe articulo condivha descripcion",Toast.LENGTH_SHORT).show();
              //  limpiarDatos();
           // }
        }//else {
           // Toast.makeText(this, "Ingrese la descripcion del articulo",Toast.LENGTH_SHORT).show();
       // }

    }
    }

