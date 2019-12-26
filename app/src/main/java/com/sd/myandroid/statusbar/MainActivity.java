package com.sd.myandroid.statusbar;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.sd.lib.statusbar.FStatusBarUtils;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FStatusBarUtils.setTransparent(getWindow(), false);
    }
}
