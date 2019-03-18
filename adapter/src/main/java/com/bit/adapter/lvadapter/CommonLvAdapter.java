package com.bit.adapter.lvadapter;

import android.content.Context;

import com.bit.adapter.lvadapter.base.ItemViewDelegate;

import java.util.List;

public abstract class CommonLvAdapter<T> extends MultiItemTypeAdapter<T> {

    public CommonLvAdapter(Context context, final int layoutId, List<T> datas) {
        super(context, datas);

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
            public void convert(ViewHolderLv holder, T t, int position) {
                CommonLvAdapter.this.convert(holder, t, position);
            }
        });
    }

    protected abstract void convert(ViewHolderLv viewHolder, T item, int position);

}
