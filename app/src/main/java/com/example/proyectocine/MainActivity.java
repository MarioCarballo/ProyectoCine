package com.example.proyectocine;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {

    private WebView myWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);

        this.myWebView = (WebView) this.findViewById(R.id.WebView);

        // Enable JavaScript WebSettings webSettings =
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // Provide a WebViewClient for your WebView
        myWebView.setWebViewClient(new MyWebViewClient());

        myWebView.loadUrl("http://mjgl.com.sv/cine/");

    }

    @Override
    public void onBackPressed() {

        // Check if there's history
        if (this.myWebView.canGoBack())
            this.myWebView.goBack();
        else
            super.onBackPressed();

    }

    private class MyWebViewClient extends WebViewClient {

        private long loadTime; // Web page loading time

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {

            if (Uri.parse(url).getHost().equals("Mi pagina web")) {
                // This is my web site, so do not override; let my WebView load
                // the page
                return false;
            }

            // Otherwise, the link is not for a page on my site, so launch
            // another Activity that handles URLs
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
            return true;

        }
    }

}