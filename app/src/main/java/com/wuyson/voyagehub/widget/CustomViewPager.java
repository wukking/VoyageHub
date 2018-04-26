package com.wuyson.voyagehub.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * 自定义ViewPager
 * 1. 页面滑动
 * 2. 页面滑动动画
 */
public class CustomViewPager extends ViewPager {
    private boolean isScroll = true;
    private boolean isSwitchAnimation = true;

    public CustomViewPager(@NonNull Context context) {
        super(context);
    }

    public CustomViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void setCurrentItem(int item, boolean smoothScroll) {
        super.setCurrentItem(item, smoothScroll);
    }

    @Override
    public void setCurrentItem(int item) {
        super.setCurrentItem(item, isSwitchAnimation);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return super.onInterceptTouchEvent(ev);
    }
//
//    @Override
//    public boolean onTouchEvent(MotionEvent ev) {
//        return isScroll && super.onTouchEvent(ev);
//    }

    /**
     * 设置页面支持滑动
     *
     * @param scroll true:支持滑动，false:关闭滑动
     */
    public void setScroll(boolean scroll) {
        isScroll = scroll;
    }

    /**
     * 页面切换动画
     *
     * @param switchAnimation true:有动画，false:无动画
     */
    public void setSwitchAnimation(boolean switchAnimation) {
        isSwitchAnimation = switchAnimation;
    }
}
