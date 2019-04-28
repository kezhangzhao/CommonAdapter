package com.bit.adapter.lvadapter.base;


import com.bit.adapter.lvadapter.ViewHolderLv;

public interface ItemViewDelegate<T> {

    int getItemViewLayoutId();

    boolean isForViewType(T item, int position);

    void convert(ViewHolderLv holder, T t, int position);

}
