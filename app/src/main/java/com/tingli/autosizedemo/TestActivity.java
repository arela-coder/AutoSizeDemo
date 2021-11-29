package com.tingli.autosizedemo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class TestActivity extends Activity {
    private static String TAG = "TestActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        handler.sendMessage(handler.obtainMessage(1000, "test1"));

        new Thread(new Runnable() {
            @Override
            public void run() {
                Looper.prepare();
                Handler handler2 = new Handler(new Handler.Callback() {
                    @Override
                    public boolean handleMessage(@NonNull Message msg) {
                        Log.d(TAG, "handleMessage2 :" + msg.what + "," + msg.obj + "," + Thread.currentThread().toString());
                        return false;
                    }
                });
                handler2.sendMessage(handler2.obtainMessage(2000, "test2"));
                Looper.loop();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                handler.sendMessage(handler.obtainMessage(3000, "test3"));
            }
        }).start();
    }

    private final Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(@NonNull Message msg) {
            Log.d(TAG, "handleMessage1 :" + msg.what + "," + msg.obj + "," + Thread.currentThread().toString());
            return false;
        }
    });


}
