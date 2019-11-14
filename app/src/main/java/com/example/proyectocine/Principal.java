package com.example.proyectocine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;


public class Principal extends AppCompatActivity {
    Button btnusuario;
    Button btncliente;
    Button btnregistro;
    Button btnrecuoperar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        btnusuario=(Button) findViewById((R.id.btnusuario));
        btncliente=(Button) findViewById((R.id.btncliente));
        btnregistro=(Button) findViewById((R.id.btnregistro));
        btnrecuoperar=(Button) findViewById((R.id.btnrecuoperar));

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        btnusuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Principal.this, Main2Activity.class);
                startActivity(intent);
            }
        });
        btncliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Principal.this, Main3Activity.class);
                startActivity(intent);
            }
        });
        btnregistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Principal.this, Main4Activity.class);
                startActivity(intent);
            }
        });
    }
}
