package com.vairagi.codes.onbordingscreen.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import com.vairagi.codes.onbordingscreen.R;
import com.vairagi.codes.onbordingscreen.models.OnBoardingData;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class OnBoardingViewPager extends PagerAdapter {
    private Context context;
    private ArrayList<OnBoardingData> onBoardingData;

    public OnBoardingViewPager(Context context, ArrayList<OnBoardingData> onBoardingData) {
        this.context = context;
        this.onBoardingData = onBoardingData;
    }

    @Override
    public int getCount() {
        return onBoardingData.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull  View view, @NonNull  Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull  ViewGroup container, int position) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.row_onboarding,container,false);

        OnBoardingData currentOnBoardingData= onBoardingData.get(position);
        ConstraintLayout constraintLayout = view.findViewById(R.id.mainLayout);
        TextView textView = view.findViewById(R.id.tv_title);
        TextView desTextView = view.findViewById(R.id.tv_des);
        ImageView mainImageView = view.findViewById(R.id.iv_on_boarding);


        constraintLayout.setBackgroundColor(currentOnBoardingData.getColor());
        textView.setText(currentOnBoardingData.getTitle());
        desTextView.setText(currentOnBoardingData.getDescription());
        mainImageView.setImageResource(currentOnBoardingData.getImageView());




        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
