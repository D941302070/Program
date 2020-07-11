package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void myclick(View view) {
        switch (view.getId()) {
            case R.id.frame:
                startActivity(new Intent(this, FrameActivity.class));
                break;
            case R.id.constraint:
                startActivity(new Intent(this, ConstraintActivity.class));
                break;
            case R.id.grid:
                startActivity(new Intent(this, GridActivity.class));
                break;
            case R.id.table:
                startActivity(new Intent(this, TableActivity.class));
                break;
        }
    }
}