package com.example.myapplication11111;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class muluActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mulu);
    }

    public void oneClick(View view){
        Intent intent1 = new Intent(muluActivity.this,TestActivity.class);
        startActivity(intent1);
    }


    public void twoClick(View view){
        Intent intent2 = new Intent(muluActivity.this,TestActivity.class);
        startActivity(intent2);
    }

    public void threeClick(View view){
        Intent intent1 = new Intent(muluActivity.this,TestActivity.class);
        startActivity(intent1);
    }


    public void foursClick(View view){
        Intent intent2 = new Intent(muluActivity.this,TestActivity.class);
        startActivity(intent2);
    }
}