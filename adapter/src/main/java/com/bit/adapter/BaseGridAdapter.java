package com.bit.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseGridAdapter<E> extends BaseAdapter {

    protected Context mContext;
    private List<E> mList = new ArrayList<>();
    protected LayoutInflater mInflater;

    public BaseGridAdapter(Context context) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
    }

    public BaseGridAdapter(Context context, List<E> list) {
        this(context);
        mList = list;
    }

    public void updateData(List<E> list){
        mList = list;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    public void clearAll() {
        mList.clear();
    }

    public List<E> getData() {
        return mList;
    }

    public void addALL(List<E> list){
        if(list==null||list.size()==0) return;
        mList.addAll(list);
    }
    public void add(E item){
        mList.add(item);
    }

    @Override
    public E getItem(int position) {
        return (E) mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void removeEntity(E e){
        mList.remove(e);
    }

}
