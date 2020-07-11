package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class TestActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //activity与layout关联
        setContentView(R.layout.activity_test);

        //通过indViewById将layout中的空间找出来，转换为View
        final TextView textView = findViewById(R.id.textView);
        //找到button这个view
        Button button = findViewById(R.id.button);


        //设置点击事件
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //为textView动态设置文本
                textView.setText(getString(R.string.app_name));
                //跳转到一个NewActivity
                //intent,意图，构造方法：从前一个activity跳转到后一个activity的意图
                //在AndroidManifest.xml声明之后才可以跳转
                Intent intent = new Intent(TestActivity.this, NewActivity.class);
                startActivity(intent);
            }
        });
    }
}
