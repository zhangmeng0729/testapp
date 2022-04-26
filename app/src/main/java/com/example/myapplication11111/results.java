package com.example.myapplication11111;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

public class results extends AppCompatActivity {

    private String userName,userClass,score,timeUsed;//INFO

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        Intent getIntent = getIntent();

        userName = getIntent.getStringExtra("name");
        userClass = getIntent.getStringExtra("class");
        score = getIntent.getStringExtra("score");
        timeUsed = getIntent.getStringExtra("time");

        system_setup();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if (keyCode == KeyEvent.KEYCODE_BACK){
            return false;
        }else{
            return super.onKeyDown(keyCode,event);
        }
    }

    public void system_setup(){
        int time = Integer.parseInt(timeUsed);
        int min = time / 60 ;
        int sec = time % 60 ;

        TextView userInfo = findViewById(R.id.user_info);
        TextView Score = findViewById(R.id.user_score);
        TextView Time = findViewById(R.id.time_used);
        userInfo.setText(userClass+"的"+userName+"同学");
        Score.setText("本次考试分数为: "+score+" 分");
        if (min == 0){
            Time.setText("用时"+sec+"秒");
        }else {
            Time.setText("用时"+min+"分"+sec+"秒");
        }


    }

    public void returnClick(View view) {
        Intent intent = new Intent(results.this,MainActivity.class);
        startActivity(intent);
    }

    public void againClick(View view) {
        Intent intent1 = new Intent(results.this,FenleiActivity.class);
        startActivity(intent1);
    }
}
