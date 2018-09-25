package com.example.test.myapplication1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void gotoDisplay(View view) {
        Intent nextPage = new Intent(MainActivity.this, displayJewelry.class);
        startActivity(nextPage);
    }

    public void gotoManager(View view){
        Intent nextPage = new Intent(this, JewelryManager.class);
        startActivity(nextPage);
    }
}
