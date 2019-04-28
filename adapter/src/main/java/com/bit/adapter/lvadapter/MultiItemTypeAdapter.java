package com.bit.adapter.lvadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;


import com.bit.adapter.lvadapter.base.ItemViewDelegate;
import com.bit.adapter.lvadapter.base.ItemViewDelegateManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MultiItemTypeAdapter<T> extends BaseAdapter {

    protected Context mContext;
    protected List<T> mDatas;
    private Map<String, ViewHolderLv> viewHolderMaps;

    private ItemViewDelegateManager mItemViewDelegateManager;


    public MultiItemTypeAdapter(Context context, List<T> datas) {
        this.mContext = context;
        this.mDatas = datas;
        mItemViewDelegateManager = new ItemViewDelegateManager();
        viewHolderMaps = new HashMap<>();
    }

    protected void addItemViewDelegate(ItemViewDelegate<T> itemViewDelegate) {
        mItemViewDelegateManager.addDelegate(itemViewDelegate);
    }

    private boolean useItemViewDelegateManager() {
        return mItemViewDelegateManager.getItemViewDelegateCount() > 0;
    }

    @Override
    public int getViewTypeCount() {
        if (useItemViewDelegateManager())
            return mItemViewDelegateManager.getItemViewDelegateCount();
        return super.getViewTypeCount();
    }

    @Override
    public int getItemViewType(int position) {
        if (useItemViewDelegateManager()) {
            return mItemViewDelegateManager.getItemViewType(mDatas.get(position), position);
        }
        return super.getItemViewType(position);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ItemViewDelegate itemViewDelegate = mItemViewDelegateManager.getItemViewDelegate(mDatas.get(position), position);
        int layoutId = itemViewDelegate.getItemViewLayoutId();
        String viewKey = itemViewDelegate.getItemViewLayoutId() + "";

        ViewHolderLv viewHolder;
        if (convertView != null && ((ViewHolderLv) convertView.getTag()).getLayoutId() == layoutId) {
            viewHolder = (ViewHolderLv) convertView.getTag();
            viewHolder.mPosition = position;
        } else {

            View itemView = LayoutInflater.from(mContext).inflate(layoutId, parent,
                    false);
            viewHolder = new ViewHolderLv(mContext, itemView, parent, position);
            viewHolder.mLayoutId = layoutId;
            onViewHolderCreated(viewHolder, viewHolder.getConvertView());
            viewHolderMaps.put(viewKey, viewHolder);

        }


        convert(viewHolder, getItem(position), position);
        return viewHolder.getConvertView();
    }

    protected void convert(ViewHolderLv viewHolder, T item, int position) {
        mItemViewDelegateManager.convert(viewHolder, item, position);
    }

    private void onViewHolderCreated(ViewHolderLv holder, View itemView) {
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public T getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void addData(T data) {
        if (data != null) {
            if (mDatas == null)
                mDatas = new ArrayList<>();
            mDatas.add(data);
        }
    }

    public void addAllDatas(List<T> dataList) {
        if (dataList != null && dataList.size() > 0) {
            if (mDatas == null)
                mDatas = new ArrayList<>();
            mDatas.addAll(dataList);
        }
    }

    public List<T> getmDatas() {
        return mDatas;
    }

    public void setmDatas(List<T> mDatas) {
        this.mDatas = mDatas;
    }
}
