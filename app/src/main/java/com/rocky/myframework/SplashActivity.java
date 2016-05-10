package com.rocky.myframework;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.rocky.myframework.adapter.GalleryPagerAdapter;
import com.rocky.myframework.base.BaseActivity;
import com.rocky.viewpagerindicator.CirclePageIndicator;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SplashActivity extends BaseActivity implements View.OnClickListener{

    @Bind(R.id.splash_iv)
    ImageView splashIv;
    @Bind(R.id.viewPager)
    ViewPager viewPager;
    @Bind(R.id.viewPagerIndicator)
    CirclePageIndicator viewPagerIndicator;
    @Bind(R.id.btn_in)
    Button btn_in;
    private int[] images = {R.mipmap.newer01, R.mipmap.newer02, R.mipmap.newer03, R.mipmap.newer04};
    private SharedPreferences splashSP;
    private Handler handler = new Handler();
    private GalleryPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//去掉信息栏
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        setSwipeBackEnable(false);
        btn_in.setOnClickListener(this);
        splashSP = getSharedPreferences("splash", MODE_PRIVATE);
        boolean first = splashSP.getBoolean("first", false);
        if (!first) {
            initGuideImage();
        } else {
            initSplashImage();
        }
    }

    private void initGuideImage() {
        final Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fadein);
        viewPager.setVisibility(View.VISIBLE);
        viewPagerIndicator.setVisibility(View.VISIBLE);
        adapter = new GalleryPagerAdapter(this, images);
        viewPager.setAdapter(adapter);
        viewPagerIndicator.setViewPager(viewPager);
        viewPagerIndicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == images.length - 1) {
                    btn_in.setVisibility(View.VISIBLE);
                    btn_in.setAnimation(fadeIn);
                } else {
                    btn_in.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initSplashImage() {
        splashIv.setVisibility(View.VISIBLE);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startMainActivity();
            }
        }, 1000);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_in:
                SharedPreferences.Editor edit = splashSP.edit();
                edit.putBoolean("first", true);
                edit.commit();
                startMainActivity();
                break;
        }
    }

    private void startMainActivity() {
        startActivity(new Intent(this, MainActivity.class));
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SplashActivity.this.finish();
            }
        }, 2000);
    }
}
