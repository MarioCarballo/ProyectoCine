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
    Dto datos = new Dto();
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
    public void limpiarDatos(){
        et_email.setText(null);
        et_identificacion.setText(null);
        et_apellido.setText(null);
        et_nombre.setText(null);
        et_pass.setText(null);
        et_pas2.setText(null);
    }

    public void consultaNombre(View v) {
        if (et_nombre.getText().toString().length()==0){
            et_nombre.setError("Campo obligatorio");
            estadoNombre=false;
        }else {
            estadoNombre=true;
        }if (estadoNombre){
            String nombre=et_nombre .getText().toString();
            datos.setNombre(nombre);
          if (conexion.consultaNombre(datos)){
               et_nombre.setText(""+datos.getNombre());
                et_apellido.setText(datos.getApellido());
               et_identificacion.setText(""+datos.getIdentificacion());
              et_email.setText(""+datos.getCorreo());
           }else {
              Toast.makeText(this,"No existe articulo con dicha descripción",Toast.LENGTH_SHORT).show();
            limpiarDatos();
           }
        }else {
        Toast.makeText(this, "Ingrese la descripción del articulo",Toast.LENGTH_SHORT).show();
        }

    }

    }

