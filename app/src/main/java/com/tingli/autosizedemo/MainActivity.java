package com.tingli.autosizedemo;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.lang.ref.WeakReference;

//public class MainActivity extends Activity {
public class MainActivity extends com.tingli.autosizedemo.AutoSizeActivity {
    String TAG = getClass().getSimpleName();

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        DisplayMetrics displayMetrics = getApplication().getResources().getDisplayMetrics();
        Log.d(TAG, "onConfigurationChanged displayMetrics: " + displayMetrics.toString());
        Log.d(TAG, "onConfigurationChanged displayMetrics: width in dp:" + displayMetrics.widthPixels / displayMetrics.density);
        Log.d(TAG, "onConfigurationChanged displayMetrics: height in dp:" + displayMetrics.heightPixels / displayMetrics.density);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mycar_autosize);

        DisplayMetrics displayMetrics = getApplication().getResources().getDisplayMetrics();
        Log.d(TAG, "onCreate displayMetrics: " + displayMetrics.toString());
        Log.d(TAG, "onCreate displayMetrics: width in dp:" + displayMetrics.widthPixels / displayMetrics.density);
        Log.d(TAG, "onCreate displayMetrics: height in dp:" + displayMetrics.heightPixels / displayMetrics.density);

        /**
         * [MyCarApplication]:displayMetrics: DisplayMetrics{density=1.0, width=1920, height=620, scaledDensity=1.0, xdpi=224.737,
         * ydpi=134.47}
         */

        // 1920*720
        //DisplayMetrics{density=1.3312501, width=1920, height=720, scaledDensity=1.3312501, xdpi=213.0, ydpi=213.0}

        //DisplayMetrics{density=2.75, width=1920, height=1080, scaledDensity=2.75, xdpi=440.0, ydpi=440.0}


        // DisplayMetrics{density=1.0, width=1280, height=720, scaledDensity=1.0, xdpi=160.0, ydpi=160.0}


    }


}
