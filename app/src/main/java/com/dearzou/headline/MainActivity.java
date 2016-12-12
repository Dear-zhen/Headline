package com.dearzou.headline;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;

import com.dearzou.headline.adapter.HeadlineViewPagerAdapter;
import com.dearzou.headline.module.home.fragment.NetEaseNewsListFargment;
import com.dearzou.headline.module.home.fragment.QQNewsListFragment;
import com.dearzou.headline.module.home.fragment.ZhiHuDailyListFragment;
import com.dearzou.headline.widget.WechatRadioGroup;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private ViewPager mViewPager;

    private WechatRadioGroup mWechatRadioGroup;

    private ViewGroup mWechatRadioLayOut;

    private ViewGroup mTitelBar;

    private LinearLayout mTopLayOut, mBottomLayOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initView();
    }

    public void initView() {

        mTopLayOut = (LinearLayout) findViewById(R.id.top_layout);
        mBottomLayOut = (LinearLayout) findViewById(R.id.bottom_layout);

        mViewPager = (ViewPager) findViewById(R.id.main_viewPager);
        mViewPager.setAdapter(new HeadlineViewPagerAdapter(getSupportFragmentManager(), getFragments()));

        initWechatRadioGroup();
        initTitleBar();
    }


    private List<Fragment> getFragments() {

        List<Fragment> list = new ArrayList<Fragment>();
        list.add(new NetEaseNewsListFargment());
        list.add(new QQNewsListFragment());
        list.add(new ZhiHuDailyListFragment());

        return list;
    }

    private void initWechatRadioGroup() {

        mWechatRadioLayOut = (ViewGroup) LayoutInflater.from(this).inflate(R.layout.wechatradiogroup_layout, null);
        mWechatRadioGroup = (WechatRadioGroup) mWechatRadioLayOut.findViewById(R.id.wechatradiogroup);
        mBottomLayOut.addView(mWechatRadioLayOut);
        mWechatRadioGroup.setViewPager(mViewPager);

    }

    private void initTitleBar() {

        mTitelBar = (ViewGroup) LayoutInflater.from(this).inflate(R.layout.titlebar, null);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        mTitelBar.setLayoutParams(params);
        mTopLayOut.addView(mTitelBar);
    }

    public LinearLayout getmTopLayOut() {
        return mTopLayOut;
    }

    public LinearLayout getmBottomLayOut() {
        return mBottomLayOut;
    }

}
