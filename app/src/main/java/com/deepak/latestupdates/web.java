package com.deepak.latestupdates;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class web extends AppCompatActivity {
    WebView webView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_web );



        webView = findViewById( R.id.web );
        String url = getIntent().getStringExtra( "url" );
            webView.loadUrl( url );
            webView.getSettings().setLoadsImagesAutomatically( true );
            webView.getSettings().setJavaScriptEnabled( true );
            final ProgressDialog progressDialog = new ProgressDialog( this );
            progressDialog.setTitle( "New Page" );
            progressDialog.setMessage( "Loading....!" );
            webView.setWebViewClient( new WebViewClient() {

                                          @Override
                                          public void onPageStarted(WebView view, String url, Bitmap favicon) {
                                              super.onPageStarted( view, url, favicon );
                                              progressDialog.show();
                                          }

                                          @Override
                                          public void onPageFinished(WebView view, String url) {
                                              super.onPageFinished( view, url );
                                              progressDialog.dismiss();
                                          }
                                      }

            );

        }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent(web.this,MainActivity.class);
        startActivity( intent );
    }
    }