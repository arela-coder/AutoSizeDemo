package com.tingli.autosizedemo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;

public class MainActivity extends Activity {
    //public class MainActivity extends com.tingli.autosizedemo.AutoSizeActivity {
    String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        DisplayMetrics displayMetrics = getApplication().getResources().getDisplayMetrics();
        Log.d(TAG, "displayMetrics: " + displayMetrics.toString());

        /**
         * 10-01 08:00:09.030  4381  4381 D ScreenShare: [ScreenManager]:presentation display Display id 2: DisplayInfo{"HDMI 屏幕",
         * uniqueId "local:2", app 1920 x 720, real 1920 x 720, largest app 1920 x 1920, smallest app 720 x 720, mode 3, defaultMode 3,
         * modes [{id=3, width=1920, height=720, fps=60.0}], colorMode 0, supportedColorModes [0], hdrCapabilities android.view
         * .Display$HdrCapabilities@40f16308, rotation 0, density 213 (213.0 x 213.0) dpi, layerStack 2, appVsyncOff 1000000,
         * presDeadline 16666667, type HDMI, state ON, FLAG_SECURE, FLAG_SUPPORTS_PROTECTED_BUFFERS, FLAG_PRESENTATION, removeMode 0},
         * DisplayMetrics{density=1.3312501, width=1920, height=720, scaledDensity=1.3312501, xdpi=213.0, ydpi=213.0}, isValid=true
         *
         *
         *
         * [MyCarApplication]:displayMetrics: DisplayMetrics{density=1.0, width=1920, height=620, scaledDensity=1.0, xdpi=224.737,
         * ydpi=134.47}
         */

        // 1920*720
        //DisplayMetrics{density=1.3312501, width=1920, height=720, scaledDensity=1.3312501, xdpi=213.0, ydpi=213.0}

        //DisplayMetrics{density=2.75, width=1920, height=1080, scaledDensity=2.75, xdpi=440.0, ydpi=440.0}


        // DisplayMetrics{density=1.0, width=1280, height=720, scaledDensity=1.0, xdpi=160.0, ydpi=160.0}


    }


}
