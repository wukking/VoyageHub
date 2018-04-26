package com.wuyson.voyagehub.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.wuyson.voyagehub.widget.BannerView;

import java.util.List;

public class AppBannerVPAdapter extends PagerAdapter {
    private List<BannerView> imageViewList;
    private Context mContext;

    public AppBannerVPAdapter(Context context, List<BannerView> imageViewList) {
        this.imageViewList = imageViewList;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        //无限轮播(1/2)
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    //为什么要判断 parent 的状态？
    // 原因是如果不这样处理，在向左滑动 ViewPager 的时候会报错：
    // The specified child already has a parent. You must call removeView
    //加了parent状态 destroyItem就没必要了，否则会出现空白图

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        position %= imageViewList.size();
        BannerView child = imageViewList.get(position);
        child.setBannerTitleText(String.format("第%s标题",position+1));
        if (child.getParent() != null){
            container.removeView(child);
        }
        container.addView(child);
        return child;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//        container.removeView((View) object);
    }
}

