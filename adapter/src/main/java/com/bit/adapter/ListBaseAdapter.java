package com.bit.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 上下拉刷新的RecyclerView的基础adapter
 * Created by kezhangzhao on 2018/1/19.
 */

public class ListBaseAdapter<T> extends RecyclerView.Adapter {

    protected ArrayList<T> mDataList = new ArrayList<>();

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    /**
     * 获取数据列表
     *
     * @return List
     */
    public List<T> getDataList() {
        return mDataList;
    }

    /**
     * 设置数据
     *
     * @param list 数据列表
     */
    public void setDataList(Collection<T> list) {
        this.mDataList.clear();
        if (list != null)
            this.mDataList.addAll(list);
        notifyDataSetChanged();
    }

    /**
     * 添加list数据
     *
     * @param list List
     */
    public void addAll(Collection<T> list) {
        int lastIndex = this.mDataList.size();
        if (this.mDataList.addAll(list)) {
            notifyItemRangeInserted(lastIndex, list.size());
        }
    }

    /**
     * 删除某个数据
     *
     * @param position 数据位置
     */
    public void delete(int position) {
        mDataList.remove(position);
        notifyItemRemoved(position);
    }

    /**
     * 清除数据
     */
    public void clear() {
        mDataList.clear();
        notifyDataSetChanged();
    }
}
