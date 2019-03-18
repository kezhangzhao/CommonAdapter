package com.bit.adapter.rvadapter;

import android.content.Context;
import android.view.LayoutInflater;


import com.bit.adapter.rvadapter.base.ItemViewDelegate;

import java.util.List;

public abstract class CommonRvAdapter<T> extends MultiItemTypeAdapter<T> {
    protected Context mContext;
    protected int mLayoutId;
    protected List<T> mDatas;
    protected LayoutInflater mInflater;

    public CommonRvAdapter(final Context context, final int layoutId, List<T> datas) {
        super(context, datas);
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mLayoutId = layoutId;
        mDatas = datas;

        addItemViewDelegate(new ItemViewDelegate<T>() {
            @Override
            public int getItemViewLayoutId() {
                return layoutId;
            }

            @Override
            public boolean isForViewType(T item, int position) {
                return true;
            }

            @Override
            public void convert(ViewHolderRv holder, T t, int position) {
                CommonRvAdapter.this.convert(holder, t, position);
            }
        });
    }

    public void setData(List<T> datas) {
        if (mDatas != null) {
            this.mDatas.clear();
            this.mDatas.addAll(datas);
            notifyDataSetChanged();
        }
    }

    /**
     * 清除数据
     */
    public void cleanData() {
        if (mDatas != null) {
            this.mDatas.clear();
            notifyDataSetChanged();
        }
    }

    public abstract void convert(ViewHolderRv holder, T t, int position);

}
