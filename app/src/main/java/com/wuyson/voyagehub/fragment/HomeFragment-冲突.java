package com.wuyson.voyagehub.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;

import com.wuyson.common.base.BaseFragment;
import com.wuyson.voyagehub.R;
import com.wuyson.voyagehub.adapter.AppBannerVPAdapter;
import com.wuyson.voyagehub.utils.MessageCallback;
import com.wuyson.voyagehub.utils.MyHandler;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


public class HomeFragment extends BaseFragment {
    @BindView(R.id.vp_banner)
    ViewPager vpBanner;

    private List<Integer> images ;
    private MyHandler mHandler;
    private static final int MSG_BANNER_CIRCLE = 1;
    private AppBannerVPAdapter adapter;
    public static final int BANNER_PAUSE = 0;

    @Override
    protected int getLayoutRes() {
        return R.layout.app_fragment_home;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initView(savedInstanceState);
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        initBanner();
    }

    private void initBanner() {
        if (images == null){
            images = new ArrayList<>();
            images.add(R.drawable.img_jessica_1);
            images.add(R.drawable.img_jessica_2);
            images.add(R.drawable.img_jessica_3);
            images.add(R.drawable.img_jessica_4);
        }

        adapter = new AppBannerVPAdapter(mContext, images);

        vpBanner.setAdapter(adapter);

        mHandler = new MyHandler(mActivity, new MessageCallback() {
            @Override
            public void handleMsg(Message message) {
                switch (message.what) {
                    case MSG_BANNER_CIRCLE:
                        if (vpBanner != null) {
                            int currentItem = vpBanner.getCurrentItem();
                            currentItem++;
                            vpBanner.setCurrentItem(currentItem);
                            mHandler.sendEmptyMessageDelayed(MSG_BANNER_CIRCLE, 3000);
                        }
                        break;
                    default:
                        break;
                }
            }
        });
    }


    @Override
    public void onResume() {
        super.onResume();
        if (mHandler != null)
            mHandler.sendEmptyMessageDelayed(MSG_BANNER_CIRCLE, 3000);
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mHandler != null)
        mHandler.removeMessages(MSG_BANNER_CIRCLE);
    }
}
