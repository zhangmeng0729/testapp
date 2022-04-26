package com.example.myapplication11111;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        refresh();

    }

    public  void refresh(){
        EditText userName = findViewById(R.id.userName);
        EditText userClass = findViewById(R.id.userClass);

        userName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                EditText userName = findViewById(R.id.userName);
                EditText userClass = findViewById(R.id.userClass);
                if (!TextUtils.isEmpty(userName.getText()) & !TextUtils.isEmpty(userClass.getText())){
                    findViewById(R.id.startTest).setEnabled(true);
                }else{
                    findViewById(R.id.startTest).setEnabled(false);
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
        userClass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                EditText userName = findViewById(R.id.userName);
                EditText userClass = findViewById(R.id.userClass);
                if (!TextUtils.isEmpty(userName.getText()) && !TextUtils.isEmpty(userClass.getText())){
                    findViewById(R.id.startTest).setEnabled(true);
                }else{
                    findViewById(R.id.startTest).setEnabled(false);
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    public void startTest(View view) {

        EditText userName = findViewById(R.id.userName);
        EditText userClass = findViewById(R.id.userClass);
        String Name,Class;

        Name = userName.getText().toString();
        Class =userClass.getText().toString();
        Intent intent = new Intent();

        intent.putExtra("name",Name);
        intent.putExtra("class",Class);

        intent.setClass(MainActivity.this,FenleiActivity.class);
        startActivity(intent);
    }


}



