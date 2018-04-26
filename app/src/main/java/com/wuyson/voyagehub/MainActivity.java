package com.wuyson.voyagehub;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;

import com.wuyson.common.base.BaseActivity;
import com.wuyson.voyagehub.adapter.AppMainVPAdapter;
import com.wuyson.voyagehub.fragment.CategoryFragment;
import com.wuyson.voyagehub.fragment.CenterFragment;
import com.wuyson.voyagehub.fragment.HomeFragment;
import com.wuyson.voyagehub.fragment.MessageFragment;
import com.wuyson.voyagehub.fragment.SettingsFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements ViewPager.OnPageChangeListener,
        BottomNavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.vp_content)
    ViewPager vpContent;
    @BindView(R.id.bnv_nav)
    BottomNavigationView bnvNav;

    private List<Fragment> mFragmentList = new ArrayList<>();
    private MenuItem menuItem;

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        initPager();
        bnvNav.setOnNavigationItemSelectedListener(this);
    }

    private void initPager() {
        mFragmentList.add(new HomeFragment());
        mFragmentList.add(new CategoryFragment());
        mFragmentList.add(new CenterFragment());
        mFragmentList.add(new MessageFragment());
        mFragmentList.add(new SettingsFragment());

        vpContent.setAdapter(new AppMainVPAdapter(getSupportFragmentManager(), mFragmentList));
        vpContent.addOnPageChangeListener(this);
    }


    /**
     * =====================Listener =========================
     */

    @Override
    public void onPageSelected(int position) {
        if (menuItem != null) {
            menuItem.setChecked(false);
        } else {
            menuItem = bnvNav.getMenu().getItem(position);
            bnvNav.getMenu().getItem(position).setChecked(false);
        }
        bnvNav.getMenu().getItem(position).setChecked(true);
    }
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_home:
                vpContent.setCurrentItem(0,false);
                break;
            case R.id.menu_category:
                vpContent.setCurrentItem(1,false);
                break;
            case R.id.menu_center:
                vpContent.setCurrentItem(2,false);
                break;
            case R.id.menu_mail:
                vpContent.setCurrentItem(3,false);
                break;
            case R.id.menu_settings:
                vpContent.setCurrentItem(4,false);
                break;
            default:
                break;
        }
        return true;
    }
}
