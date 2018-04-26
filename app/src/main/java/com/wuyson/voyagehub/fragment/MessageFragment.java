package com.wuyson.voyagehub.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wuyson.common.base.BaseFragment;
import com.wuyson.voyagehub.R;
import com.wuyson.voyagehub.adapter.AppMessageVPAdapter;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MessageFragment extends BaseFragment {
    @BindView(R.id.tabs)
    TabLayout tabs;
    @BindView(R.id.view_pager)
    ViewPager viewPager;

    private List<Fragment> fragmentList;
    private List<String> titleList;
    private AppMessageVPAdapter adapter;


    @Override
    protected int getLayoutRes() {
        return R.layout.app_fragment_message;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        initPager();
    }

    private void initPager() {
        if (titleList == null) {
            titleList = new ArrayList<>();
            titleList.add("First");
            titleList.add("Second");
            titleList.add("Third");
            titleList.add("Four");
            titleList.add("Five");
            titleList.add("Six");
        }

        if (fragmentList == null){
            fragmentList = new ArrayList<>();
            fragmentList.add(new MsgTypeOneFragment());
            fragmentList.add(new MsgTypeTwoFragment());
            for (int i = 0; i < titleList.size() - 2; i++) {
                fragmentList.add(new MsgTypeThreeFragment());
            }
        }

        adapter = new AppMessageVPAdapter(getChildFragmentManager(), fragmentList, titleList);

        viewPager.setAdapter(adapter);
        tabs.setupWithViewPager(viewPager);
    }

}
