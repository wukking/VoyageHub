package com.wuyson.voyagehub.utils;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.lang.ref.WeakReference;

public class MyHandler extends Handler {
    private static final String TAG = "MyHandler";
    private WeakReference<Activity> weakActivity;
    private MessageCallback callback;

    public MyHandler(Activity activity, MessageCallback callback) {
        this.weakActivity = new WeakReference<>(activity);
        this.callback = callback;
    }

    @Override
    public void handleMessage(Message msg) {
        Log.e(TAG, "handleMessage: " );
        Activity activity = weakActivity.get();
        if (activity != null) {
            callback.handleMsg(msg);
        }
    }
}
