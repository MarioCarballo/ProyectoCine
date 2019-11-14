package com.example.proyectocine;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Main3Activity extends AppCompatActivity {

    WebView browser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        browser=(WebView)findViewById(R.id.WebView);

        WebSettings webSettings = browser.getSettings();
        webSettings.setJavaScriptEnabled(true);

        browser.setWebViewClient(new WebViewClient(){

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

        });
        // Cargamos la WEB
        browser.loadUrl("https://mjgl.com.sv/cine/index.php?c=Loginclien&a=Index");


    }
}