package com.tingli.autosizedemo;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

public class TestActivity extends Activity {
    private static TestClass testClass;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        testClass = new TestClass();
    }

    private class TestClass {
    }
}
