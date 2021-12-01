package com.tingli.autosizedemo;

import android.app.Activity;
import android.content.Intent;
import android.content.LocusId;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;

public class BaseActivity extends Activity {

    protected final String TAG = "liting-" + this.getClass().getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate ");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume ");
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.i(TAG, "onNewIntent ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy ");
    }
}
