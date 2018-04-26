package com.wuyson.voyagehub.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.wuyson.voyagehub.GlideApp;
import com.wuyson.voyagehub.R;


public class BannerView extends FrameLayout {
    private Context context;
    private ImageView imgBanner;
    private TextView tvTitleBanner;

    public BannerView(@NonNull Context context) {
        super(context);
        this.context = context;
        init();
    }

    public BannerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    public BannerView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init();
    }

    private void init() {
        View view = LayoutInflater.from(context).inflate(R.layout.view_banner, this);
        imgBanner = view.findViewById(R.id.img_banner);
        tvTitleBanner = view.findViewById(R.id.tv_title);
    }

    public void setBannerImageSource(int imgId) {
        GlideApp.with(context).load(imgId).into(imgBanner);
    }

    public void setBannerTitleText(String title) {
      tvTitleBanner.setText(title);
    }
}
