package com.sd.lib.statusbar;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class FStatusBarFitLayout extends FrameLayout
{
    private boolean mFitStatusBar = true;

    public FStatusBarFitLayout(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    public void setFitStatusBar(boolean fit)
    {
        if (mFitStatusBar != fit)
        {
            mFitStatusBar = fit;
            checkFitStatusBar();
        }
    }

    public void checkFitStatusBar()
    {
        if (mFitStatusBar)
        {
            final int statusBarHeight = FStatusBarUtils.getActivityStatusBarHeight(getContext());
            super.setPadding(getPaddingLeft(), statusBarHeight, getPaddingRight(), getPaddingBottom());
        } else
        {
            super.setPadding(getPaddingLeft(), 0, getPaddingRight(), getPaddingBottom());
        }
    }

    @Override
    public void setPadding(int left, int top, int right, int bottom)
    {
    }

    @Override
    protected void onConfigurationChanged(Configuration newConfig)
    {
        super.onConfigurationChanged(newConfig);
        checkFitStatusBar();
    }

    @Override
    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        checkFitStatusBar();
    }
}
