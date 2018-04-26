package com.wuyson.voyagehub.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wuyson.common.base.BaseFragment;
import com.wuyson.voyagehub.R;

import butterknife.BindView;

public class CategoryFragment extends BaseFragment {
    public CategoryFragment() {
    }

    @BindView(R.id.tv_category)
    TextView tvCategory;

    @Override
    protected int getLayoutRes() {
        return R.layout.app_fragment_category;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        doSomething();
    }

    private void doSomething() {

    }

    @Override
    public void onPause() {
        super.onPause();
    }
}
