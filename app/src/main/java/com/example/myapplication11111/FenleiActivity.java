package com.example.myapplication11111;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class FenleiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fenlei);
    }

    public void lianxiClick(View view){
        Intent intent1 = new Intent(FenleiActivity.this,TestActivity.class);
        startActivity(intent1);
    }


    public void ceshiClick(View view){
        Intent intent2 = new Intent(FenleiActivity.this,TestActivity.class);
        startActivity(intent2);
    }


}
