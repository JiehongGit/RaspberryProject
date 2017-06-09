package com.example.tiancai.monitor;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

public class MjpegActivity extends Activity{

	private EditText edIP;
    private Button openbutton;
    public static String CameraIp;

    //android初始化
    @Override
    public void onCreate(Bundle savedInstanceState) {
        //设置当前的Activity 无Title并且全屏
        //调用这个方法有个限制,即必须在setContentView(R.layout.main)之前调用,否则会抛出异常
    	requestWindowFeature(Window.FEATURE_NO_TITLE);

        //强制为横屏
    	setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        //super指的是父类；onCreate是一个函数，一般的Actitivy的入口都是这个函数；savedInstanceState是形参
        super.onCreate(savedInstanceState);

        //设置一个Activity的显示界面
        //所在的Activity采用R.layout下的main布局文件进行布局
        setContentView(R.layout.main);

        //定义控件
        edIP=(EditText)findViewById(R.id.editIP);
        openbutton=(Button)findViewById(R.id.openbtn);

        //获取输入的地址
        CameraIp =edIP.getText().toString();
        
        openbutton.setOnClickListener(new Button.OnClickListener()
        {
              public void onClick(View v) {
            	  Intent intent = new Intent(getApplication(), surface.class);
            	  Bundle bundle = new Bundle();
            	  bundle.putString("CameraIp", CameraIp);
            	  intent.putExtras(bundle);
            	  startActivity(intent);
            }
        });
    }
}