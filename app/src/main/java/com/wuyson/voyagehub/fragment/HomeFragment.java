package com.wuyson.voyagehub.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.wuyson.common.base.BaseFragment;
import com.wuyson.voyagehub.R;
import com.wuyson.voyagehub.adapter.AppBannerVPAdapter;
import com.wuyson.voyagehub.widget.BannerView;
import com.wuyson.voyagehub.widget.BannerViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class HomeFragment extends BaseFragment {

    @BindView(R.id.vp_banner)
    BannerViewPager vpBanner;
    private List<BannerView > imageList;
    private List<String> titles = new ArrayList<>();
    private int[] imgIds;
    private Handler handler;
    private Runnable runnable;
    private AppBannerVPAdapter adapter;

    @Override
    protected int getLayoutRes() {
        return R.layout.app_fragment_home;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        initBanner();
    }

    private void initBanner() {
        if (imageList == null) {
            imgIds = new int[]{R.drawable.img_jessica_1, R.drawable.img_jessica_2,
                    R.drawable.img_jessica_3, R.drawable.img_jessica_4};

            imageList = new ArrayList<>();
            for (int imgId : imgIds) {
                BannerView bannerView = new BannerView(mContext);
                bannerView.setBannerImageSource(imgId);
                imageList.add(bannerView);
            }
        }

        if (adapter == null){
            adapter = new AppBannerVPAdapter(mContext, imageList);
        }else {
            adapter.notifyDataSetChanged();
        }
        vpBanner.setAdapter(adapter);

        adapter.setOnItemClickListener(new AppBannerVPAdapter.OnItemClickListener() {
            @Override
            public void onItemClickListener(int position) {
                Toast.makeText(mActivity, position+"", Toast.LENGTH_SHORT).show();
            }
        });

        vpBanner.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        vpBanner.performClick();
                        handler.removeCallbacks(runnable);
                        break;
                    case MotionEvent.ACTION_UP:
                        handler.postDelayed(runnable, 3000);
                        break;
                    case MotionEvent.ACTION_CANCEL:
                        handler.postDelayed(runnable, 3000);
                        break;
                    default:
                        break;
                }
                return false;
            }
        });

        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                int currentItem = vpBanner.getCurrentItem();
                if (currentItem == vpBanner.getAdapter().getCount() - 1) {
                    vpBanner.setCurrentItem(1);
                } else {
                    vpBanner.setCurrentItem(currentItem + 1);
                }
                handler.postDelayed(runnable, 3000);
            }
        };
    }


    @Override
    public void onResume() {
        super.onResume();
        handler.postDelayed(runnable, 3000);
    }

    @Override
    public void onPause() {
        super.onPause();
        handler.removeCallbacks(runnable);
    }

}
