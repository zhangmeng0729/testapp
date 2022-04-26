package com.example.myapplication11111;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class TestActivity extends AppCompatActivity {

    Timer timer =new Timer(true);

    String userName,userClass;//INFO
    int setTime;

    int [] num_a =new int[50]; //NUM
    int [] num_b =new int[50];
    int [] ans = new int[50];
    String [] user_ans = new String[50];

    int page; //UI
    Button pgup;
    Button pgdn;
    TextView page_info;
    TextView time_label;
    int time;

    TextView T1; EditText A1; //TEST
    TextView T2; EditText A2;
    TextView T3; EditText A3;
    TextView T4; EditText A4;
    TextView T5; EditText A5;
    TextView T6; EditText A6;
    TextView T7; EditText A7;
    TextView T8; EditText A8;
    TextView T9; EditText A9;
    TextView T10; EditText A10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        Intent getIntent = getIntent();

        userName = getIntent.getStringExtra("name");
        userClass = getIntent.getStringExtra("class");

        TextView userInfo = findViewById(R.id.userinfo);
        userInfo.setText("姓名："+userName+" 班级:"+userClass);

        system_setup();
        watcher();
        count_down();

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
        page = 1;
        pgup = findViewById(R.id.pgup);
        pgdn = findViewById(R.id.pgdn)      ;
        page_info = findViewById(R.id.page_info);
        time_label = findViewById(R.id.time);
        pgup.setEnabled(false);
        page_info.setText("第 "+page+" 页 共 5 页");
        setTime = 1800;
        time = setTime;

        T1 = findViewById(R.id.test1); A1 = findViewById(R.id.ans1);
        T2 = findViewById(R.id.test2); A2 = findViewById(R.id.ans2);
        T3 = findViewById(R.id.test3); A3 = findViewById(R.id.ans3);
        T4 = findViewById(R.id.test4); A4 = findViewById(R.id.ans4);
        T5 = findViewById(R.id.test5); A5 = findViewById(R.id.ans5);
        T6 = findViewById(R.id.test6); A6 = findViewById(R.id.ans6);
        T7 = findViewById(R.id.test7); A7 = findViewById(R.id.ans7);
        T8 = findViewById(R.id.test8); A8 = findViewById(R.id.ans8);
        T9 = findViewById(R.id.test9); A9 = findViewById(R.id.ans9);
        T10 = findViewById(R.id.test10); A10 = findViewById(R.id.ans10);

        questions_setup();
        page_change();
    }

    public void questions_setup(){

        Random rnd = new Random();

        for(int i = 0; i < 50 ; i = i + 1){
            num_a [i] = rnd.nextInt(90) + 10;
            num_b [i] = rnd.nextInt(90) + 10;
            ans [i] = num_a [i] + num_b [i];
        }
    }

    public void count_down(){
        TimerTask CD = new TimerTask() {
            @Override
            public void run() {
                time = time -1;
                final int min = time / 60;
                final int sec = time % 60;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        time_label.setText(min+"分"+sec+"秒");
                    }
                });
            }
        };

        timer.schedule(CD,0,1000);
    }

    public void handIn(View view) {
        timer.cancel();
        String score = get_score();
        String time_used = String.valueOf(setTime- time);

        Intent putIntent = new Intent();

        putIntent.putExtra("name",userName);
        putIntent.putExtra("class",userClass);
        putIntent.putExtra("score",score);
        putIntent.putExtra("time", time_used);

        putIntent.setClass(TestActivity.this,results.class);
        startActivity(putIntent);
    }

    public String get_score(){
        int score = 0;
        String output;
        for (int i = 0;i < 50;i++){
            int temp;
            if (user_ans[i] == null){
                temp = 0;
            }else {
                temp = Integer.parseInt(user_ans[i]);
            }
            if (temp == ans[i]) score = score + 2;
        }
        output = Integer.toString(score);
        return output;
    }

    public void pgup(View view) {
        page = page - 1;
        if (page <= 1){
            pgup.setEnabled(false);
        }else{
            pgdn.setEnabled(true);
        }
        page_info.setText("第 "+page+" 页 共 5 页");
        page_change();
    }

    public void pgdn(View view) {
        page = page + 1;
        if (page >= 5) {
            pgdn.setEnabled(false);
        } else {
            pgup.setEnabled(true);
        }
        page_info.setText("第 " + page + " 页 共 5 页");
        page_change();
    }

    public void page_change(){
        int i = (page - 1) * 10;
        T1.setText(num_a[i]+" + "+num_b[i]+" =");
        T2.setText(num_a[i+1]+" + "+num_b[i+1]+" =");
        T3.setText(num_a[i+2]+" + "+num_b[i+2]+" =");
        T4.setText(num_a[i+3]+" + "+num_b[i+3]+" =");
        T5.setText(num_a[i+4]+" + "+num_b[i+4]+" =");
        T6.setText(num_a[i+5]+" + "+num_b[i+5]+" =");
        T7.setText(num_a[i+6]+" + "+num_b[i+6]+" =");
        T8.setText(num_a[i+7]+" + "+num_b[i+7]+" =");
        T9.setText(num_a[i+8]+" + "+num_b[i+8]+" =");
        T10.setText(num_a[i+9]+" + "+num_b[i+9]+" =");

        A1.setText(user_ans[i]);
        A2.setText(user_ans[i+1]);
        A3.setText(user_ans[i+2]);
        A4.setText(user_ans[i+3]);
        A5.setText(user_ans[i+4]);
        A6.setText(user_ans[i+5]);
        A7.setText(user_ans[i+6]);
        A8.setText(user_ans[i+7]);
        A9.setText(user_ans[i+8]);
        A10.setText(user_ans[i+9]);
    }

    public void refresh(int num){
        int i = (page - 1) * 10;

        switch (num){
            case 1:
                if (!A1.getText().toString().isEmpty()) user_ans[i] = A1.getText().toString();
                break;
            case 2:
                if (!A2.getText().toString().isEmpty()) user_ans[i+1] = A2.getText().toString();
                break;
            case 3:
                if (!A3.getText().toString().isEmpty()) user_ans[i+2] = A3.getText().toString();
                break;
            case 4:
                if (!A4.getText().toString().isEmpty()) user_ans[i+3] = A4.getText().toString();
                break;
            case 5:
                if (!A5.getText().toString().isEmpty()) user_ans[i+4] = A5.getText().toString();
                break;
            case 6:
                if (!A6.getText().toString().isEmpty()) user_ans[i+5] = A6.getText().toString();
                break;
            case 7:
                if (!A7.getText().toString().isEmpty()) user_ans[i+6] = A7.getText().toString();
                break;
            case 8:
                if (!A8.getText().toString().isEmpty()) user_ans[i+7] = A8.getText().toString();
                break;
            case 9:
                if (!A9.getText().toString().isEmpty()) user_ans[i+8] = A9.getText().toString();
                break;
            case 10:
                if (!A10.getText().toString().isEmpty()) user_ans[i+9] = A10.getText().toString();
                break;
        }
    }

    public void watcher(){
        A1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                refresh(1);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        A2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                refresh(2);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        A3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                refresh(3);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        A4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                refresh(4);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        A5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                refresh(5);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        A6.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                refresh(6);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        A7.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                refresh(7);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        A8.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                refresh(8);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        A9.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                refresh(9);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        A10.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                refresh(10);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }


}