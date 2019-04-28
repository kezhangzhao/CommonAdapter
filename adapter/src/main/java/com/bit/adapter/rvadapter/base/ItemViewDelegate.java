package com.bit.adapter.rvadapter.base;


import com.bit.adapter.rvadapter.ViewHolderRv;

public interface ItemViewDelegate<T> {

    int getItemViewLayoutId();

    boolean isForViewType(T item, int position);

    void convert(ViewHolderRv holder, T t, int position);
}
