package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void register(View view) {
        //1.判断姓名密码是否为空
        EditText nameEdit = findViewById(R.id.name);
        EditText pwdEdit = findViewById(R.id.pwd);
        final ProgressBar proBar = findViewById(R.id.progress);

        //getText()获取text属性的内容，返回值为Editable，为可编辑文本
        String name = nameEdit.getText().toString();
        String pwd = pwdEdit.getText().toString();
        if (name.equals("") || pwd.equals("")) {
            //2.如果为空，则提示
            //无焦点提示
            //参数1：环境上下文 参数2：提示性文本   参数3：提示时间
            Toast.makeText(this, "姓名密码不能为空", Toast.LENGTH_SHORT).show();
        } else {
            //3.都不为空，则出现进度条
            proBar.setVisibility(View.VISIBLE);
            new Thread(){
                @Override
                public void run() {
                    for (int i = 0; i < 100; i++) {
                        proBar.setProgress(i);
                        try {
                            Thread.sleep(30);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }.start();
        }
    }
}