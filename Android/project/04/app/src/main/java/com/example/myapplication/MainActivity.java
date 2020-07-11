package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CheckBox checkBox = findViewById(R.id.checkBox);

        //设置是否选中（设置状态）
        checkBox.setChecked(false);
        //获取状态，是否选中
        final boolean ischecked = checkBox.isChecked();

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                //当状态被改变的时候，可以处理很多的数据和UI
                Log.d("tag",""+b);
            }
        });

        SeekBar seekBar = findViewById(R.id.seekBar);
        seekBar.setProgress(40);
        seekBar.setMax(100);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                //进度改变,i进度
                //回调很多次
                Log.d("tag","onProgressChanged"+i);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //开始拖动
                Log.d("tag","onStartTrackingTouch"+seekBar.getProgress());
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //停止拖动
                Log.d("tag","onStopTrackingTouch"+seekBar.getProgress());
            }
        });
    }
}