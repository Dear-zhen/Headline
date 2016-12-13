package com.dearzou.headline.module.home.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.dearzou.headline.BaseFragment;
import com.dearzou.headline.MainActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZouZhen on 2016/12/11.
 */

public class BaseHomeFragment extends BaseFragment {

    protected MainActivity mContext;

    protected View mRootView;

    protected RecyclerView mRecyclerView;

    protected LinearLayoutManager mLinearLayoutManager;

    protected SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = (MainActivity) getActivity();
    }

    protected List<String> getTestData() {

        List<String> list = new ArrayList<String>();

        for (int i = 0; i < 300; i++) {

            list.add(i + "");

        }
        return list;
    }
}
