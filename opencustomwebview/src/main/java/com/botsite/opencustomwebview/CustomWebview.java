package com.botsite.opencustomwebview;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;

public class CustomWebview extends AppCompatActivity {

    private WebView webview;
    private ProgressDialog progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_webview);

        webview = (WebView) findViewById(R.id.webview);

        String url = getIntent().getStringExtra("url");

        progressBar = new ProgressDialog(CustomWebview.this);
        progressBar.setMessage("Please Wait....");
        progressBar.setCancelable(false);
        progressBar.show();

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;

        int expectedHeight = (int) (width/1.595744680851063);
        webview.setLayoutParams(new RelativeLayout.LayoutParams( getDimensions(width,height,1.595744680851063)[0], getDimensions(width,height,1.595744680851063)[1] ));

        webview.getSettings().setJavaScriptEnabled(true);
        webview.getSettings().setDomStorageEnabled(true);
        webview.setWebChromeClient(new WebChromeClient());
        webview.loadUrl(url);
        webview.setWebViewClient(new MyBrowser());
    }

    public int[] getDimensions(int width, int height, double aspectRatio) {
        double expectedWidth = width;
        double expectedHeight =  width / aspectRatio;
        if (expectedHeight > height) {
            expectedHeight = height;
            expectedWidth = (expectedHeight * aspectRatio)- 380;
        }
        if (expectedWidth > width) {
            expectedWidth = width;
            expectedHeight = expectedWidth / aspectRatio;
        }

        int calculatedWidth = (int) expectedWidth;
        int calculatedHeight = (int) expectedHeight;
        int[] newArray = {calculatedWidth,calculatedHeight} ;

        Log.e("Array value",expectedWidth+" \n height: "+ expectedHeight);

        return newArray;
    }

    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            progressBar.dismiss();

        }
    }
}
