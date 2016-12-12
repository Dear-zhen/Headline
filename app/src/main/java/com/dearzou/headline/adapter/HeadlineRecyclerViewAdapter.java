package com.dearzou.headline.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dearzou.headline.R;

import java.util.List;

/**
 * Created by ZouZhen on 2016/12/11.
 */

public class HeadlineRecyclerViewAdapter extends RecyclerView.Adapter<HeadlineRecyclerViewAdapter.HeadlineViewHolder>{


    private List<String> mDatas;

    private int mLayoutResource;

    public HeadlineRecyclerViewAdapter(List<String> list,int layoutResource){

        mDatas = list;
        mLayoutResource = layoutResource;

    }

    @Override
    public HeadlineViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(mLayoutResource, parent, false);
        return new HeadlineViewHolder(view);

    }

    @Override
    public void onBindViewHolder(HeadlineViewHolder viewHolder, int position) {
        viewHolder.setData(mDatas.get(position));
    }

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    class HeadlineViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle;

        public HeadlineViewHolder(View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.text);
        }

        public void setData(String data) {
            tvTitle.setText(data);
        }

    }
}
