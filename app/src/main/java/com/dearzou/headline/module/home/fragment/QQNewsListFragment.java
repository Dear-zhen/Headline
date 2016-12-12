package com.dearzou.headline.module.home.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dearzou.headline.R;
import com.dearzou.headline.adapter.HeadlineRecyclerViewAdapter;
import com.dearzou.headline.animation.AnimationHelper;
import com.dearzou.headline.behavior.RecyclerViewBehavior;

/**
 * Created by ZouZhen on 2016/12/11.
 */

public class QQNewsListFragment extends BaseHomeFragment {



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (mRootView == null) {
            mRootView = inflater.inflate(R.layout.fragment_qqnews_list_layout, container, false);
            initView(mRootView);
        } else {
            ViewGroup parent = (ViewGroup) mRootView.getParent();
            if (null != parent) {
                parent.removeView(mRootView);
            }
        }
        return mRootView;

    }

    public void initView(View rootView){
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.home_recyclerView);
        mLinearLayoutManager = new LinearLayoutManager(mContext);
        mLinearLayoutManager.setSmoothScrollbarEnabled(true);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setAdapter(new HeadlineRecyclerViewAdapter(getTestData(),R.layout.test));

        mSwipeRefreshLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.swipeRefresh);

        RecyclerViewBehavior recyclerViewBehavior = RecyclerViewBehavior.from(mSwipeRefreshLayout);
        recyclerViewBehavior.setOnStateChangedListener(new RecyclerViewBehavior.OnStateChangedListener() {
            @Override
            public void onChanged(boolean isShow) {

                if (isShow) {

                    AnimationHelper.topLayOutShow(mContext,mContext.getmTopLayOut());
                    AnimationHelper.bottomLayOutShow(mContext,mContext.getmBottomLayOut());

                }else{


                    AnimationHelper.topLayOutHide(mContext,mContext.getmTopLayOut());
                    AnimationHelper.bottomLayOutHide(mContext,mContext.getmBottomLayOut());

                }
            }
        });
    }
}
