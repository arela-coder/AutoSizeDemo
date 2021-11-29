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

import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;

import java.lang.annotation.Documented;
import java.lang.ref.WeakReference;

public class MainActivity extends Activity {
    String TAG = getClass().getSimpleName();

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        DisplayMetrics displayMetrics = getApplication().getResources().getDisplayMetrics();
        updateDeviceInfo(displayMetrics);
    }

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        //        setContentView(R.layout.activity_test);

        DisplayMetrics displayMetrics = getApplication().getResources().getDisplayMetrics();
        updateDeviceInfo(displayMetrics);
        Handler handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(@NonNull Message msg) {
                return false;
            }
        });

        /**
         * [MyCarApplication]:displayMetrics: DisplayMetrics{density=1.0, width=1920, height=620, scaledDensity=1.0, xdpi=224.737,
         * ydpi=134.47}
         */
        // 1920*720
        //DisplayMetrics{density=1.3312501, width=1920, height=720, scaledDensity=1.3312501, xdpi=213.0, ydpi=213.0}
        //DisplayMetrics{density=2.75, width=1920, height=1080, scaledDensity=2.75, xdpi=440.0, ydpi=440.0}
        // DisplayMetrics{density=1.0, width=1280, height=720, scaledDensity=1.0, xdpi=160.0, ydpi=160.0}
    }


    private void updateDeviceInfo(DisplayMetrics displayMetrics) {
        Log.d(TAG, "updateDeviceInfo displayMetrics: " + displayMetrics.toString());
        Log.d(TAG, "updateDeviceInfo displayMetrics: width in dp:" + displayMetrics.widthPixels / displayMetrics.density);
        Log.d(TAG, "updateDeviceInfo displayMetrics: height in dp:" + displayMetrics.heightPixels / displayMetrics.density);
        TextView infoTV = findViewById(R.id.device_info);
        infoTV.setText(getString(R.string.dpi_test) + "\n");
        infoTV.append("pixel is :" + displayMetrics.widthPixels + "*" + displayMetrics.heightPixels + "\n");
        infoTV.append("density  is " + displayMetrics.density + "\n");
        //        infoTV.append("width and height in dp is :" + displayMetrics.widthPixels / displayMetrics.density + "*" +
        //        displayMetrics.heightPixels / displayMetrics.density + "\n");
    }


}
