package com.tingli.autosizedemo.eventbus;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

import com.tingli.autosizedemo.BaseActivity;
import com.tingli.autosizedemo.R;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EventTestActivity2 extends BaseActivity {

    @BindView(R.id.post_button)
    Button mPostBtn;
    int index = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus_test);

        ButterKnife.bind(this);
        mPostBtn.setText(" post");
        mPostBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String message = "test " + ++index;
                Log.d(TAG, "post FirstEvent :" + message + " in thread: " + Thread.currentThread().toString());
                EventBus.getDefault().post(new FirstEvent(message));

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String message = "test " + ++index;
                        Log.d(TAG, "post FirstEvent :" + message + " in thread: " + Thread.currentThread().toString());
                        EventBus.getDefault().post(new FirstEvent(message));
                    }
                }).start();


                message = "test " + ++index;
                //                Log.d(TAG, "post SecondEvent :" + message + " in thread: " + Thread.currentThread().toString());
                //                EventBus.getDefault().post(new SecondEvent(message));

                Log.d(TAG, "post FirstEvent :" + message + " in thread: " + Thread.currentThread().toString());
                EventBus.getDefault().postSticky(new FirstEvent(message));

                mPostBtn.setText("跳转到EventTestActivity3页面");
                mPostBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(EventTestActivity2.this, EventTestActivity3.class));
                    }
                });
            }
        });

    }
}
