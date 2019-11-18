package com.example.proyectocine;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class acerca_de extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acerca_de);

    }

    public void  acerca_de(View view){

        Intent i = new Intent(this, acerca_de.class);
        startActivity(i);
    }
}
