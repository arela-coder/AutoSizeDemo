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
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EventTestActivity extends BaseActivity {

    @BindView(R.id.post_button)
    Button mPostBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus_test);
        ButterKnife.bind(this);
        //注册
        EventBus.getDefault().register(this);

        mPostBtn.setText("跳转到EventTestActivity2页面");
        mPostBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EventTestActivity.this, EventTestActivity2.class));
            }
        });

    }

    @Subscribe(threadMode = ThreadMode.ASYNC, priority = 0)
    public void onEventAsync(FirstEvent firstEvent) {
        String msg = firstEvent.getMessage();
        Log.d(TAG, "onEventAsync: firstEvent msg:" + msg + "--" + Thread.currentThread().toString());
    }

    public void onEventMainThread(FirstEvent firstEvent) {
        String msg = firstEvent.getMessage();
        Log.d(TAG, "onEventMainThread: firstEvent msg:" + msg + "--" + Thread.currentThread().toString());
    }

    @Subscribe(threadMode = ThreadMode.POSTING, priority = 0)
    public void onEventMain(FirstEvent firstEvent) {
        String msg = firstEvent.getMessage();
        Log.d(TAG, "onEventMain: firstEvent msg:" + msg + "--" + Thread.currentThread().toString());
    }

    @Subscribe(threadMode = ThreadMode.POSTING, sticky = true, priority = 1)
    public void onGetMessage(FirstEvent firstEvent) {
        String msg = firstEvent.getMessage();
        Log.d(TAG, "onGetMessage: firstEvent msg:" + msg + "--" + Thread.currentThread().toString());
        //        EventBus.getDefault().cancelEventDelivery(firstEvent);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(SecondEvent secondEvent) {
        String msg = secondEvent.getMessage();
        //        Log.d(TAG, "onEvent: secondEvent msg:" + msg + "--" + Thread.currentThread().toString());
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

}
