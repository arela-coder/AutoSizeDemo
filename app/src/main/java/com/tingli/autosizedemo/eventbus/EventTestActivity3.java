package com.tingli.autosizedemo.eventbus;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.annotation.Nullable;

import com.tingli.autosizedemo.BaseActivity;
import com.tingli.autosizedemo.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EventTestActivity3 extends BaseActivity {

    @BindView(R.id.post_button)
    Button mPostBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus_test);
        ButterKnife.bind(this);
        //注册
        EventBus.getDefault().register(this);

        mPostBtn.setText("Event Test Activity3页面");
    }

    /**
     * 事件响应方法
     * 接收消息
     *
     * @param firstEvent
     */
    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void onEvent(FirstEvent firstEvent) {
        String msg = firstEvent.getMessage();
        Log.d(TAG, "onEvent: firstEvent msg:" + msg + "--" + Thread.currentThread().toString());
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onGetMessage(FirstEvent firstEvent) {
        String msg = firstEvent.getMessage();
        Log.d(TAG, "onGetMessage: firstEvent msg:" + msg + "--" + Thread.currentThread().toString());
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
