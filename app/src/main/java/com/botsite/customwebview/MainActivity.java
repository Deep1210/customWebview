package com.botsite.customwebview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.botsite.opencustomwebview.CustomWebview;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, CustomWebview.class);
        intent.putExtra("url", "https://www.google.com");
        startActivity(intent);
    }
}
