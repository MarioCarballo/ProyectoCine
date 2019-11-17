package com.example.proyectocine;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class GuardarEmpleado extends AppCompatActivity {

    private Button btnguardar;
    private EditText et_nombre, et_apellido, et_identificacion, et_email, et_pass;

    boolean estadoNombre = false;
    boolean estadoApellido = false;
    boolean estadoIdentificacion = false;
    boolean estadoEmail = false;
    boolean estadoClave = false;
    int estadoInsert = 0;

    ConexionSQLite conexion = new ConexionSQLite(this);
    Dto datos = new Dto();
    AlertDialog.Builder dialogo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guardar_empleado);

        btnguardar=(Button)findViewById(R.id.btnguardar) ;
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


          if (estadoNombre && estadoApellido && estadoIdentificacion && estadoEmail && estadoClave) {
             try {
               datos.setNombre(et_nombre.getText().toString());
             datos.setApellido(et_apellido.getText().toString());
                 datos.setIdentificacion(et_identificacion.getText().toString());
                 datos.setCorreo(et_email.getText().toString());
                 datos.setContra1(et_pass.getText().toString());
         if (conexion.InsertarTradicional(datos)){
          Toast.makeText(this, "registro agregado satisfactoriamente!", Toast.LENGTH_SHORT).show();
        limpiarDatos();
        }else {
          Toast.makeText(GuardarEmpleado.this, "Error. Ya existe un registro\n"+ " identificacion: "
               +et_identificacion   .getText().toString(), Toast.LENGTH_SHORT).show();
        limpiarDatos();

         }
        }catch (Exception e){
         Toast.makeText(this, "Error. Ya existe.", Toast.LENGTH_SHORT).show();
        }

    }
}
    public void mensaje (String mensaje){
        Toast.makeText(this, ""+mensaje, Toast.LENGTH_SHORT).show();
    }

}
