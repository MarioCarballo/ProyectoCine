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
    private EditText et_nombre, et_apellido, et_identificacion, et_email, et_pass;

    boolean estadoNombre = false;
    boolean estadoApellido = false;
    boolean estadoIdentificacion = false;
    boolean estadoEmail = false;
    boolean estadoClave = false;

    int estadoInsert = 0;

    boolean inputEn = false;
    boolean InputEA = false;
    boolean inputEI = false;
    boolean inputEE = false;
    boolean inputEC = false;

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



    }
    public void limpiarDatos(){
        et_email.setText(null);
        et_identificacion.setText(null);
        et_apellido.setText(null);
        et_nombre.setText(null);
        et_pass.setText(null);

    }

    public void consultaporcodigo(View v) {

        if (et_identificacion.getText().toString().length() == 0) {
            et_identificacion.setError("Campo Obligatorio");
            inputEI = false;
        } else {
            inputEI = true;
        }
        if (inputEI) {
            String identificacion = et_identificacion.getText().toString();
            datos.setIdentificacion(Integer.parseInt(identificacion));

            if (conexion.consultacodigo(datos) == true) {
                et_nombre.setText(""+datos.getNombre());
                et_apellido.setText(""+datos.getApellido());
                et_identificacion.setText( ""+datos.getIdentificacion());
                et_email.setText(""+datos.getCorreo());
                et_pass.setText(""+datos.getContra1());
            } else {
                Toast.makeText(this, "no existe tal usuario ", Toast.LENGTH_SHORT).show();


            }
        }else{
            Toast.makeText(this, "ingrese el codigo a buscar", Toast.LENGTH_SHORT).show();
        }
    }

    public void modificar(View view) {

        if (et_identificacion.getText().toString().length()==0){
            et_identificacion.setError("campo obligatorio");
            inputEI=false;
        }else {
            inputEI=true;
        }
        if (inputEI){


            String nombre=et_nombre.getText().toString();
            String apellido=et_apellido.getText().toString();
            Integer identificacion= Integer.parseInt(et_identificacion.getText().toString());
            String correo=et_email.getText().toString();
            String contra=et_pass.getText().toString();

            datos.setNombre(nombre);
            datos.setApellido(apellido);
            datos.setIdentificacion(identificacion);
            datos.setCorreo(correo);
            datos.setContra1(contra);

            if (conexion.modificar(datos)){
                Toast.makeText(this,"Registro modificado",Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this,"No se ha encontrado resultados de la busqueda",Toast.LENGTH_SHORT).show();
            }
        }
    }
    }

