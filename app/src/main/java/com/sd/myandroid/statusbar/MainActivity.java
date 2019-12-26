package com.sd.myandroid.statusbar;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.sd.lib.statusbar.FStatusBarUtils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    public static final String TAG = MainActivity.class.getSimpleName();

    private boolean mDarkStatusBar = true;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FStatusBarUtils.setTransparent(getWindow(), mDarkStatusBar);
    }

    @Override
    public void onClick(View v)
    {
        mDarkStatusBar = !mDarkStatusBar;
        FStatusBarUtils.setTransparent(getWindow(), mDarkStatusBar);
    }
}
