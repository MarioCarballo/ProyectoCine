package com.example.proyectocine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText et_usuario, et_pass;
    Button btnlog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_usuario=(EditText)findViewById((R.id.et_usuario));
        et_pass=(EditText)findViewById((R.id.et_pass));
        btnlog=(Button) findViewById((R.id.btnlog));

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        btnlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usu = et_usuario.getText().toString();
                String pass = et_pass.getText().toString();

            }
        });
    }
}
