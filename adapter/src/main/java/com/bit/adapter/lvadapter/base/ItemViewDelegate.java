package com.bit.adapter.lvadapter.base;


import com.bit.adapter.lvadapter.ViewHolderLv;

public interface ItemViewDelegate<T>
{

    public abstract int getItemViewLayoutId();

    public abstract boolean isForViewType(T item, int position);

    public abstract void convert(ViewHolderLv holder, T t, int position);

}
