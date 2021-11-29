package com.tingli.autosizedemo;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class AutoSizeActivity extends Activity {

    private final String TAG = getClass().getSimpleName();
    private final static boolean BASED_WIDTH = true;
    // TODO 缓存
    //    private static SparseArray<DisplayMetricsInfo> mCache = new SparseArray<>();

    //
    private int designWidth = 1920;
    private int designHeight = 720;

    //屏幕宽度（像素）  屏幕高度（像素）
    private int screenWidth, screenHeight;

    // 屏幕密度（0.75 / 1.0 / 1.5）
    private float originalDensity, currentDensity;

    // 屏幕密度DPI（120 / 160 / 240）
    private int originalDensityDpi, currentDensityDpi;

    //
    public float originalScaledDensity, currentScaledDensity;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public void setContentView(int layoutResID) {
        init();
        super.setContentView(layoutResID);
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        init();
        super.onConfigurationChanged(newConfig);
    }

    /**
     * 是否横屏
     *
     * @return isLand
     */
    public boolean isLandScreenChange(Context context) {
        Configuration mConfiguration = context.getResources().getConfiguration(); //获取设置的配置信息
        return mConfiguration.orientation == Configuration.ORIENTATION_LANDSCAPE;
    }

    private void init() {
        if (isLandScreenChange(this))
        {
            designWidth = 1920;
            designHeight = 720;
        }
        else
        {
            designWidth = 720;
            designHeight = 1920;
        }

        DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
        screenWidth = displayMetrics.widthPixels;
        screenHeight = displayMetrics.heightPixels;
        originalDensity = displayMetrics.density;
        originalDensityDpi = displayMetrics.densityDpi;
        originalScaledDensity = displayMetrics.scaledDensity;

        Log.d(TAG, "start init:" + displayMetrics.toString());
        if (BASED_WIDTH)
        {
            currentDensity = screenWidth * 1.0f / designWidth;
        }
        else
        {
            currentDensity = screenHeight * 1.0f / designHeight;
        }
        originalDensityDpi = (int) (currentDensity * 160);

        currentScaledDensity = currentDensity * (originalScaledDensity / originalDensity);

        setDensity(displayMetrics, currentDensity, currentDensityDpi, currentScaledDensity);
        Log.d(TAG, "end init:" + displayMetrics.toString());
    }


    /**
     * DisplayMetrics赋值
     *
     * @param displayMetrics {@link DisplayMetrics}
     * @param density        {@link DisplayMetrics#density}
     * @param densityDpi     {@link DisplayMetrics#densityDpi}
     * @param scaledDensity  {@link DisplayMetrics#scaledDensity}
     */
    private static void setDensity(DisplayMetrics displayMetrics, float density, int densityDpi, float scaledDensity) {
        displayMetrics.density = density;
        displayMetrics.densityDpi = densityDpi;
        displayMetrics.scaledDensity = scaledDensity;
    }

    /**
     * Configuration赋值
     *
     * @param configuration  {@link Configuration}
     * @param screenWidthDp  {@link Configuration#screenWidthDp}
     * @param screenHeightDp {@link Configuration#screenHeightDp}
     */
    private static void setScreenSizeDp(Configuration configuration, int screenWidthDp, int screenHeightDp) {
        configuration.screenWidthDp = screenWidthDp;
        configuration.screenHeightDp = screenHeightDp;
    }

    private void setDensity(float density, int densityDpi, float scaledDensity) {
        /*
         * 由于 API 26 及以上的 Activity#getResources()#getDisplayMetrics() 和 Application#getResources()#getDisplayMetrics() 是不同的引用，所以在 API 26
         * 及以上适配是没有影响的，但在 API 26 以下 Activity#getResources()#getDisplayMetrics() 和 Application#getResources()#getDisplayMetrics()
         * 是相同的引用，导致适配有问题
         */
        DisplayMetrics activityDisplayMetrics = this.getResources().getDisplayMetrics();
        setDensity(activityDisplayMetrics, density, densityDpi, scaledDensity);

        //        DisplayMetrics appDisplayMetrics = getApplication().getResources().getDisplayMetrics();
        //        setDensity(appDisplayMetrics, density, densityDpi, scaledDensity, xdpi);
    }

    private void setScreenSizeDp(int screenWidthDp, int screenHeightDp) {
        Configuration activityConfiguration = this.getResources().getConfiguration();
        setScreenSizeDp(activityConfiguration, screenWidthDp, screenHeightDp);

        //        Configuration appConfiguration = getApplication().getResources().getConfiguration();
        //        setScreenSizeDp(appConfiguration, screenWidthDp, screenHeightDp);
    }
}
