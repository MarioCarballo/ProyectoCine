package com.example.proyectocine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class splash2_activity extends AppCompatActivity {
    Button btnusuario;
    Button btncliente;
    Button btnregistro;
    Button btnrecuoperar;
    private final int DURACION_SPLASH =2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash_activity);
        btnusuario=(Button) findViewById((R.id.btnusuario));
        btncliente=(Button) findViewById((R.id.btncliente));
        btnregistro=(Button) findViewById((R.id.btnregistro));
        btnrecuoperar=(Button) findViewById((R.id.btnrecuoperar));

        btnusuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Handler().postDelayed(new Runnable(){
                    @Override
                    public void run() {
                        Intent intent= new Intent(splash2_activity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    };


                }, DURACION_SPLASH);
            }
        });

        btncliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Handler().postDelayed(new Runnable(){
                    @Override
                    public void run() {
                        Intent intent= new Intent(splash2_activity.this, Main2Activity.class);
                        startActivity(intent);
                        finish();
                    };


                }, DURACION_SPLASH);
            }
        });
        btnregistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Handler().postDelayed(new Runnable(){
                    @Override
                    public void run() {
                        Intent intent= new Intent(splash2_activity.this, Main3Activity.class);
                        startActivity(intent);
                        finish();
                    };


                }, DURACION_SPLASH);
            }
        });
        btnrecuoperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Handler().postDelayed(new Runnable(){
                    @Override
                    public void run() {
                        Intent intent= new Intent(splash2_activity.this, Main4Activity.class);
                        startActivity(intent);
                        finish();
                    };


                }, DURACION_SPLASH);
            }
        });


    }
}
