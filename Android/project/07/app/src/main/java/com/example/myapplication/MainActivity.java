package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ctx_button:延时ContextMenu
        //1.注册
        //registerForContextMenu(findViewById(R.id.ctx_button));
        //2.创建 覆盖onCreateContextMenu

        //3.菜单项的操作 覆盖onContextItemSelected


        //4.为按钮设置上下文操作模式
        //4.1实现接口ActionMode.CallBack
        //4.2在View的长按事件中去启动上下文操作模式
        findViewById(R.id.ctx_button).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                startActionMode(cb);
                return false;
            }
        });


        //popup_btn:演示PopupMenu
        final Button popupBtn = findViewById(R.id.popup_button);
        popupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //1.实例化PopupMenu对象(参数2：出现在谁的下方)
                PopupMenu menu = new PopupMenu(MainActivity.this, popupBtn);
                //2.加载菜单资源：利用MenuInflater将mean资源加载到PopupMenu.getMenu()所返回的Menu对象中
                //将R.id.xx对于的菜单资源加载到弹出式菜单中
                menu.getMenuInflater().inflate(R.menu.popup, menu.getMenu());
                //3.为PopupMenu设置点击监听器
                menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.copy:
                                Toast.makeText(MainActivity.this, "复制", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.paste:
                                Toast.makeText(MainActivity.this, "粘贴", Toast.LENGTH_SHORT).show();
                                break;
                        }
                        return false;
                    }
                });
                //4.显示PopupMenu
                menu.show();
            }
        });
    }

    ActionMode.Callback cb = new ActionMode.Callback() {
        //创建，在启动上下文操作（startActionMode(Callback)）模式时调用
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            Log.e("TAG", "创建");
            getMenuInflater().inflate(R.menu.context, menu);
            return true;
        }

        //在创建方法后进行调用
        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            Log.e("TAG", "准备");
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            Log.e("TAG", "点击");
            switch (item.getItemId()) {
                case R.id.delete:
                    Toast.makeText(MainActivity.this, "删除", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.opear1:
                    Toast.makeText(MainActivity.this, "操作1", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.opear2:
                    Toast.makeText(MainActivity.this, "操作2", Toast.LENGTH_SHORT).show();
                    break;
            }
            return true;
        }

        //上下文模式结束时被调用
        @Override
        public void onDestroyActionMode(ActionMode mode) {
            Log.e("TAG", "结束");
        }
    };
    /*
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.context, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.delete:
                Toast.makeText(this, "删除", Toast.LENGTH_SHORT).show();
                break;
            case R.id.opear1:
                Toast.makeText(this, "操作1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.opear2:
                Toast.makeText(this, "操作2", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);
    }
     */

    //创建OptingMenu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //加载菜单资源
        //通过xml代码设计
        //getMenuInflater().inflate(R.menu.option, menu);

        //纯java代码设计
        /*
        设置
        更多
            添加
            删除
         */
        //参数1：组id, 参数2：菜单项id，参数3：序号
        menu.add(1, 1, 1, "设置");
        SubMenu sub = menu.addSubMenu(1, 2, 2, "更多");
        sub.add(2, 3, 1, "添加");
        sub.add(2, 4, 2, "删除");
        //必须返回true
        return true;
    }

    //OptingMenu菜单项选中的方法
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            /*
            case R.id.save:
                Toast.makeText(this, "保存", Toast.LENGTH_SHORT).show();
                break;
            case R.id.setting:
                Toast.makeText(this, "设置", Toast.LENGTH_SHORT).show();
                break;
            case R.id.exit:
                finish();//退出程序
                break;
             */
            case 1:
                Toast.makeText(this, "设置", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(this, "更多", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(this, "添加", Toast.LENGTH_SHORT).show();
                break;
            case 4:
                Toast.makeText(this, "删除", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}