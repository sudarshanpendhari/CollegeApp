package com.codedev.college;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;

import android.app.ProgressDialog;
import android.os.Bundle;

import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;



public class WebActivity extends AppCompatActivity {
    private WebView webView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        String url=getIntent().getStringExtra("url");
        webView = findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient());
        ProgressDialog pd = new ProgressDialog(WebActivity.this);
        pd.setMessage("loading");
        pd.show();


        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url)
            {

                webView.loadUrl("javascript:(function() { " +
                                "document.getElementsByClassName('well home-well-custom')[0].remove();document.getElementsByClassName('well home-well-custom1 web-view')[0].remove(); document.getElementsByClassName('container-fluid')[0].remove(); document.getElementsByClassName('res-view')[0].remove();   document.getElementsByClassName('well home-well-footer')[0].remove(); document.getElementsByClassName('carousel slide')[0].remove(); document.getElementsByClassName('well vm-well-custom')[0].remove(); " + "})()");
                webView.setVisibility(View.VISIBLE);



            }

        });

        webView.loadUrl(url);
        pd.dismiss();







    }
}