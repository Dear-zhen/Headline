package com.dearzou.headline.util;

import android.content.Context;
import android.graphics.Color;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.dearzou.headline.config.Config;


public class ImageLoader {
    private ImageLoader() {
    }

    public static void loadImage(Context context, String url, ImageView imageView) {
        if (Config.isNight) {
            imageView.setAlpha(0.2f);
            imageView.setBackgroundColor(Color.BLACK);
        }
        Glide.with(context).load(url).centerCrop().into(imageView);
    }
}
