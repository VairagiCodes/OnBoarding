package com.vairagi.codes.onbordingscreen.models;

import android.graphics.Color;

public class OnBoardingData {
    private int imageView;
    private String title;
    private String description;
    private int color;

    public OnBoardingData(int imageView, String title, String description, int color) {
        this.imageView = imageView;
        this.title = title;
        this.description = description;
        this.color = color;
    }

    public int getImageView() {
        return imageView;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getColor() {
        return color;
    }
}
