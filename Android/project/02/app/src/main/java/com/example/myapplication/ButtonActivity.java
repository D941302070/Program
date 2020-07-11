package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ButtonActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);
        //1.获取按钮
        Button btn1 = findViewById(R.id.btn1);
        //点击事件：被点击时触发的事件
        MyClickListener mcl = new MyClickListener();
        //2.为按钮注册点击事件监听器
        btn1.setOnClickListener(mcl);


        Button btn2 = findViewById(R.id.btn2);
        //创建了匿名内部类
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("TAG","匿名内部类");
            }
        });

        //使用本类实现的View.OnClickListener接口
        Button btn3 = findViewById(R.id.btn3);
        btn3.setOnClickListener(this);
    }

    //本类实现了View.OnClickListener接口
    @Override
    public void onClick(View view) {
        Log.e("TAG","用本类实现了OnClickListener");
    }

    //创建了内部类
    class MyClickListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            //在控制台输出一条语句
            Log.e("TAG","刚刚点击按钮是注册了内部类监听器对象");
        }
    }


    //xml文件中绑定的方法
    //参数，被点击的对象
    public void myClick(View v){
        switch (v.getId()){
            case R.id.btn4:
                Log.e("TAG","btn4通过XML绑定的点击事件");
                break;
            case R.id.btn5:
                Log.e("TAG","btn5通过XML绑定的点击事件");
        }
    }
}