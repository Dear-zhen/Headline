package com.dearzou.headline.animation;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.view.View;

import com.dearzou.headline.util.DisplayUtil;

/**
 * Created by ZouZhen on 2016/12/10.
 */

public class AnimationHelper {

    /**
     * 动画执行时间
     */
    public final static long DURATION = 600;

    /**
     * 主页LayOut隐藏时需要偏移的距离
     */
    public final static long TRANSLATIONY = 100;

    /**
     * 主页LayOut归位时移动的距离
     */
    public final static long RESETY = 0;


    private static LinearOutSlowInInterpolator LINEAROUTSLOWININTERPOLATOR = new LinearOutSlowInInterpolator();


    public static void topLayOutShow(Context context, View view) {

        ViewCompat.animate(view)
                .translationY(DisplayUtil.dip2px(context, RESETY))
                .setInterpolator(LINEAROUTSLOWININTERPOLATOR)
                .setDuration(DURATION)
                .start();

    }

    public static void topLayOutHide(Context context, View view) {

        ViewCompat.animate(view)
                .translationY(-DisplayUtil.dip2px(context, TRANSLATIONY))
                .setInterpolator(LINEAROUTSLOWININTERPOLATOR)
                .setDuration(DURATION)
                .start();

    }

    public static void bottomLayOutShow(Context context, View view) {

        ViewCompat.animate(view)
                .translationY(-DisplayUtil.dip2px(context, RESETY))
                .setInterpolator(LINEAROUTSLOWININTERPOLATOR)
                .setDuration(DURATION)
                .start();

    }

    public static void bottomLayOutHide(Context context, View view) {

        ViewCompat.animate(view)
                .translationY(DisplayUtil.dip2px(context, TRANSLATIONY))
                .setInterpolator(LINEAROUTSLOWININTERPOLATOR)
                .setDuration(DURATION)
                .start();
    }


}
