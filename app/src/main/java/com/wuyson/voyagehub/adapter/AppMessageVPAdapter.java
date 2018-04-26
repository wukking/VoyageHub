package com.wuyson.voyagehub.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.ViewGroup;


import java.util.List;

public class AppMessageVPAdapter extends FragmentPagerAdapter {
//    private List<Integer> mImageList;
//    private List<String> mTitleList;
//List<Integer> imageList, List<String> titleList
//            this.mImageList = imageList;
//        this.mTitleList = titleList;


//    private List<Integer> imageList = new ArrayList<>();
//        imageList.add(R.drawable.img_jessica_1);
//        imageList.add(R.drawable.img_jessica_2);
//        imageList.add(R.drawable.img_jessica_3);
//        imageList.add(R.drawable.img_jessica_4);

    private List<Fragment> fragmentList;
    private List<String> titleList;
    private FragmentManager fm;


    public AppMessageVPAdapter(FragmentManager fm, List<Fragment> fragmentList,List<String> titleList) {
        super(fm);
        this.fragmentList = fragmentList;
        this.titleList = titleList;
        this.fm = fm;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position%titleList.size());
    }
//
//    @Override
//    public void destroyItem(ViewGroup container, int position, Object object) {
//        container.removeView(fragmentList.get(position).getView());
//    }

    //刷新fragment
    public void setFragments(FragmentManager fm,List<Fragment> fragments,List<String> mTitles) {
        this.titleList = mTitles;
        if (this.fragmentList != null) {
            FragmentTransaction ft = fm.beginTransaction();
            for (Fragment f : this.fragmentList) {
                ft.remove(f);
            }
            ft.commitAllowingStateLoss();
            ft = null;
            fm.executePendingTransactions();
        }
        this.fragmentList = fragments;
        notifyDataSetChanged();
    }
}
