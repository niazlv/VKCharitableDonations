package com.Niyaz.vkcharitabledonations;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public abstract class MainActivity extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);
        // Убрать ActionBar
        getSupportActionBar().hide();
        if (android.os.Build.VERSION.SDK_INT >= 21){
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            ((Window) window).setStatusBarColor(Color.DKGRAY);
        }
    }
    public void start(View v){
        setContentView(R.layout.starts);
    }

    public void back2(View v){
        setContentView(R.layout.start);
    }

    public void target2(View v){
        setContentView(R.layout.target3);
    }

    public void regular2(View v){
    }

}