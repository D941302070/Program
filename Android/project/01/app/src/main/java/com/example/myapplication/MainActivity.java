package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    //Activity:可视化界面
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView设置内容视图
        //R：为每一个资源文件按类别分配一个索引
        //使程序员可以通过R.类别名.资源名去操作对应的资源
        //setContentView(R.layout.activity_main);

        //代码实现设置布局
        //1.根布局为线性布局
        LinearLayout ll = new LinearLayout(this);
        //2.设置宽高
        //第一个参数为宽，第二个参数为高
        ll.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        //3.背景设为红色
        ll.setBackgroundColor(Color.RED);
        //4.指定此Activity内容为线性布局
        setContentView(ll);
    }
}