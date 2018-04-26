package com.wuyson.common.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment extends Fragment {

    protected FragmentActivity mActivity;
    protected Context mContext;
    Unbinder unbinder;
    protected View view;

    protected final String TAG = this.getClass().getSimpleName();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(getLayoutRes(), container, false);
        }
        unbinder = ButterKnife.bind(this, view);
        mActivity = getActivity();
        mContext = getContext();
        initView(savedInstanceState);
        return view;
    }

    protected abstract int getLayoutRes();

    protected abstract void initView(Bundle savedInstanceState);

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

}
