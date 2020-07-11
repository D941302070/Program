package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.myapplication.model.Food;
import com.example.myapplication.model.Person;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText mNameEditText;
    private RadioGroup mSexRadioGroup;
    private CheckBox mHotCheckBox, mSeafoodCheckBox, mSourCheckBox;
    private SeekBar mSeekBar;
    private Button mSearchButton;
    private ImageView mFoodImageView;
    private ToggleButton mToggleButton;

    private List<Food> mFoodResult;
    private Person mPerson;
    private List<Food> mFoods;

    private boolean isSeafood;
    private boolean isHot;
    private boolean isSour;
    private int price;
    private int mCurrentIndex;//当前选择的菜的索引

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //1.初始化空间
        findView();

        //2.初始化数据
        initData();

        //3.为空间添加监控器，实现基本功能
        setListener();
    }

    private void initData() {
        // new 出来一个空的食物 list
        mFoods = new ArrayList<>();

        // 初始化添加所有的数据
        mFoods.add(new Food("麻辣香锅", 55, R.drawable.malaxiangguo, true, false, false));
        mFoods.add(new Food("水煮鱼", 48, R.drawable.shuizhuyu, true, true, false));
        mFoods.add(new Food("麻辣火锅", 80, R.drawable.malahuoguo, true, true, false));
        mFoods.add(new Food("清蒸鲈鱼", 68, R.drawable.qingzhengluyu, false, true, false));
        mFoods.add(new Food("桂林米粉", 15, R.drawable.guilin, false, false, false));
        mFoods.add(new Food("上汤娃娃菜", 28, R.drawable.wawacai, false, false, false));
        mFoods.add(new Food("红烧肉", 60, R.drawable.hongshaorou, false, false, false));
        mFoods.add(new Food("木须肉", 40, R.drawable.muxurou, false, false, false));
        mFoods.add(new Food("酸菜牛肉面", 35, R.drawable.suncainiuroumian, false, false, true));
        mFoods.add(new Food("西芹炒百合", 38, R.drawable.xiqin, false, false, false));
        mFoods.add(new Food("酸辣汤", 40, R.drawable.suanlatang, true, false, true));

        mPerson = new Person();

        mFoodResult = new ArrayList<>();
    }

    private void findView() {
        mNameEditText = findViewById(R.id.nameEditText);
        mSexRadioGroup = findViewById(R.id.genderRadioGroup);
        mHotCheckBox = findViewById(R.id.hotCheckBox);
        mSeafoodCheckBox = findViewById(R.id.seafoodCheckBox);
        mSourCheckBox = findViewById(R.id.sourCheckBox);
        mSeekBar = findViewById(R.id.seekBar);
        mSeekBar.setProgress(40);
        mSearchButton = findViewById(R.id.searchButton);
        mFoodImageView = findViewById(R.id.image);
        mToggleButton = findViewById(R.id.showToggleButton);
        mToggleButton.setChecked(true);
    }

    private void setListener() {
        //姓名
        mNameEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (mPerson != null) {
                    mPerson.setName(s.toString());
                }
            }
        });
        //性别单选
        mSexRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.maleRadioButton:
                        mPerson.setSex("男");
                        break;
                    case R.id.femaleRadioButton:
                        mPerson.setSex("女");
                        break;
                }
            }
        });
        //多选海鲜
        mSeafoodCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isSeafood = isChecked;
            }
        });

        //多选辣
        mHotCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isHot = isChecked;
            }
        });

        //多选酸
        mSourCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isSour = isChecked;
            }
        });

        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                price = seekBar.getProgress();
                //底部提示
                Toast.makeText(MainActivity.this, "价格: " + price, Toast.LENGTH_LONG).show();
            }
        });

        mSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search();
            }
        });

        mToggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mToggleButton.isChecked()) {
                    mCurrentIndex++;
                    if (mCurrentIndex < mFoodResult.size()) {
                        mFoodImageView.setImageResource(mFoodResult.get(mCurrentIndex).getPic());
                    }
                } else {
                    if (mCurrentIndex < mFoodResult.size()) {
                        String foodName = mFoodResult.get(mCurrentIndex).getName();
                        String personName = mPerson.getName();
                        String sex = mPerson.getSex();
                        Toast.makeText(MainActivity.this, "菜名: " + foodName + "，人名：" + personName + ",性别：" + sex, Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(MainActivity.this, "没有啦", Toast.LENGTH_LONG).show();

                    }
                }
            }
        });
    }

    private void search() {
        //每次清空列表
        //遍历所有菜
        //如果符合条件，则加入到列表中

        //如果为空先初始化
        if (mFoodResult == null) mFoodResult = new ArrayList<>();

        //先清除之前的结果
        mFoodResult.clear();

        //当前显示的是结果中第几个菜
        mCurrentIndex = 0;

        for (Food mFood : mFoods) {
            if (mFood != null) {
                //价格小于设定的价格
                //是顾客选择的口味
                if (mFood.getPrice() < price &&
                        (mFood.isHot() == isHot
                                || mFood.isSeafood() == isSeafood
                                || mFood.isSour() == isSour)) {
                    mFoodResult.add(mFood);
                }
            }
        }

        //先显示第一张图片
        if (mCurrentIndex < mFoodResult.size()) {
            mFoodImageView.setImageResource(mFoodResult.get(mCurrentIndex).getPic());
        }
    }
}