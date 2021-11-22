package com.tingli.autosizedemo;

import android.content.Context;

import java.lang.ref.WeakReference;

public class SingleInstance {

    private static SingleInstance singleton;
    private Context mContext;

    private SingleInstance(Context context) {
        this.mContext = context;
    }

    public static SingleInstance getInstance(Context context) {
        if (singleton == null)
        {
            synchronized (SingleInstance.class)
            {
                if (singleton == null)
                {
                    singleton = new SingleInstance(context.getApplicationContext());
                }
            }
        }
        return singleton;
    }
}
