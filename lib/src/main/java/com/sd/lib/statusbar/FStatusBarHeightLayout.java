package com.sd.lib.statusbar;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class FStatusBarHeightLayout extends FrameLayout
{
    public FStatusBarHeightLayout(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        final int statusBarHeight = FStatusBarUtils.getActivityStatusBarHeight(getContext());
        setMeasuredDimension(getMeasuredWidth(), statusBarHeight);
    }

    @Override
    public void setPadding(int left, int top, int right, int bottom)
    {
        super.setPadding(left, 0, right, 0);
    }
}
