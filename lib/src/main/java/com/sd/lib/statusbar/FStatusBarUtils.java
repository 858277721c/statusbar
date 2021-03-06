package com.sd.lib.statusbar;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class FStatusBarUtils
{
    /**
     * 全透明状态栏
     */
    public static void setTransparent(Window window, boolean dark)
    {
        if (Build.VERSION.SDK_INT >= 21)
        {
            int flag = window.getDecorView().getSystemUiVisibility();
            flag = addFlag(flag, View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            if (dark)
            {
                flag = addFlag(flag, View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
                flag = clearFlag(flag, View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            } else
            {
                flag = addFlag(flag, View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
                flag = clearFlag(flag, View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            }
            window.getDecorView().setSystemUiVisibility(flag);

            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

            if (window.getStatusBarColor() != Color.TRANSPARENT)
                window.setStatusBarColor(Color.TRANSPARENT);
        } else if (Build.VERSION.SDK_INT >= 19)
        {
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

            //虚拟键盘也透明
            //getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }

    /**
     * 半透明状态栏
     */
    public static void setHalfTransparent(Window window)
    {
        if (Build.VERSION.SDK_INT >= 21)
        {
            int flag = window.getDecorView().getSystemUiVisibility();
            flag = addFlag(flag, View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            flag = addFlag(flag, View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.getDecorView().setSystemUiVisibility(flag);

            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        } else if (Build.VERSION.SDK_INT >= 19)
        {
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

            //虚拟键盘也透明
            // getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }

    private static int addFlag(int original, int flag)
    {
        final int result = original | flag;
        return result;
    }

    private static int clearFlag(int original, int flag)
    {
        final int result = original & (~flag);
        return result;
    }

    /**
     * 状态栏高度
     *
     * @param context
     * @return
     */
    public static int getStatusBarHeight(Context context)
    {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0)
        {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    /**
     * Activity的状态栏高度
     *
     * @param context
     * @return
     */
    public static int getActivityStatusBarHeight(Context context)
    {
        if (context instanceof Activity)
        {
            final Activity activity = (Activity) context;
            final boolean isStatusBarVisible = ((activity.getWindow().getAttributes().flags & WindowManager.LayoutParams.FLAG_FULLSCREEN) == 0);

            if (isStatusBarVisible)
                return getStatusBarHeight(context);
            else
                return 0;
        } else
        {
            return getStatusBarHeight(context);
        }
    }
}
