package com.tingli.autosizedemo;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class AutoActivity extends com.tingli.autosizedemo.AutoSizeActivity {
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
        setContentView(R.layout.activity_mycar_autosize);

        DisplayMetrics displayMetrics = getApplication().getResources().getDisplayMetrics();
        updateDeviceInfo(displayMetrics);

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
        infoTV.append("density  is " + displayMetrics.density + "");
    }


}
