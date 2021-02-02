package com.thoughtworks.glideappicondemo;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView icon = findViewById(R.id.appIcon);
        System.out.println("Current Thread Id: " + Thread.currentThread().getId());
        Glide.with(this)
                .load("com.youdao.note")
                .into(icon);
    }

    private String getTopPackage()
    {
        try {
            ActivityManager am = (ActivityManager) this.getSystemService(Activity.ACTIVITY_SERVICE);
            ComponentName cn = am.getRunningTasks(1).get(0).topActivity;
            return cn.getPackageName();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}