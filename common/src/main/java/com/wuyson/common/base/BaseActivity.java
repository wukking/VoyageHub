package com.wuyson.common.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.wuyson.common.utils.AppManager;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {
    protected Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        doBeforeSetContentView();
        setContentView(getLayoutRes());

        ButterKnife.bind(this);
        mContext = this;

        initView(savedInstanceState);
    }

    private void doBeforeSetContentView() {
        AppManager.getInstance().addActivity(this);
    }

    protected abstract int getLayoutRes();

    public abstract void initView(Bundle savedInstanceState);


    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppManager.getInstance().finishActivity(this);

    }
}
