package com.example.proyectocine;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

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
    }
}
