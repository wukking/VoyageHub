package com.wuyson.voyagehub.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.wuyson.voyagehub.GlideApp;

import java.util.List;

public class AppBannerVPAdapter extends PagerAdapter {
    private List<Integer> mList;
    private Context mContext;

    public AppBannerVPAdapter(Context context, List<Integer> mList) {
        this.mList = mList;
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

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView imageView = new ImageView(mContext);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        GlideApp.with(mContext)
                //无限轮播(2/2)
                .load(mList.get(position % mList.size()))
                .into(imageView);
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
