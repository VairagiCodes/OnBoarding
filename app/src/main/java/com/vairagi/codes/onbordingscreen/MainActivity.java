package com.vairagi.codes.onbordingscreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator;
import com.vairagi.codes.onbordingscreen.adapter.OnBoardingViewPager;
import com.vairagi.codes.onbordingscreen.models.OnBoardingData;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private ArrayList<OnBoardingData> onBoardingData;
    private OnBoardingViewPager onBoardingViewPager;
    private WormDotsIndicator wormDotsIndicator;
    private LinearLayout nextBtn;
    private int page = 0;
    private Button getStartedBtn;
    private RelativeLayout bottomRelativeLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.onBoardingViewPager);
        nextBtn = findViewById(R.id.btn_next);
        wormDotsIndicator = findViewById(R.id.worm_dots_indicator);
        getStartedBtn = findViewById(R.id.btn_get_started);
        bottomRelativeLayout = findViewById(R.id.bottom_rel);
        onBoardingData = new ArrayList<>();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
              onBoardingData.add(new OnBoardingData(R.drawable.first,getString(R.string.get_inspired),getString(R.string.tv_description),getColor(R.color.first_color)));
              onBoardingData.add(new OnBoardingData(R.drawable.ic_undraw_yoga,getString(R.string.get_inspired),"I offer you peace. I offer you love. I offer you friendship. I see your beauty. I hear your need. I feel your feelings. My wisdom flows from the highest source. I salute that source in you. Let us work together for unity and love",getColor(R.color.second_color)));
              onBoardingData.add(new OnBoardingData(R.drawable.ic_undraw_mindfulness,getString(R.string.get_inspired),"To understand the immeasurable, the mind must be extraordinarily quiet, still",getColor(R.color.third_color)));
        }

        onBoardingViewPager = new OnBoardingViewPager(this,onBoardingData);
        viewPager.setAdapter(onBoardingViewPager);
        wormDotsIndicator.setViewPager(viewPager);

        View overLay = findViewById(R.id.myLayout);
        overLay.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_FULLSCREEN);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(page == 0) {
                   viewPager.setCurrentItem(1,true);
               }

               else if(page == 1) {
                   viewPager.setCurrentItem(2,true);
               }
            }
        });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                page = position;
                if(position == 0) {
                    bottomRelativeLayout.setVisibility(View.VISIBLE);
                    getStartedBtn.setVisibility(View.GONE);
                }
                else if(position == 1) {
                    bottomRelativeLayout.setVisibility(View.VISIBLE);
                    getStartedBtn.setVisibility(View.GONE);
                }

                else if(position == 2) {

                    bottomRelativeLayout.setVisibility(View.GONE);
                    getStartedBtn.setVisibility(View.VISIBLE);

                }

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }



}