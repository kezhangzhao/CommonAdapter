package com.bit.adapter.rvadapter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bit.adapter.R;


/**
 * author : zhangzhao.ke
 * time   : 2019/02/19
 * desc   : 分割线
 */

public class SimpleDividerItemDecoration extends RecyclerView.ItemDecoration {

    private Drawable mDivider;     //分割线Drawable
    private int mDividerHeight;  //分割线高度

    /**
     * 使用line_divider中定义好的颜色
     *
     * @param context       context
     * @param dividerHeight 分割线高度
     */
    public SimpleDividerItemDecoration(Context context, float dividerHeight) {
        mDivider = ContextCompat.getDrawable(context, R.drawable.recyclerview_line_divider);
        mDividerHeight = dp2px(context, dividerHeight);
    }

    /**
     * @param context       context
     * @param drawableId    分割线drawableId
     * @param dividerHeight 分割线高度
     */
    public SimpleDividerItemDecoration(Context context, @DrawableRes int drawableId, float dividerHeight) {
        mDivider = ContextCompat.getDrawable(context, drawableId);
        mDividerHeight = dp2px(context, dividerHeight);
    }

    /**
     * @param context       context
     * @param divider       分割线Drawable
     * @param dividerHeight 分割线高度
     */
    public SimpleDividerItemDecoration(Context context, Drawable divider, float dividerHeight) {
        if (divider == null) {
            mDivider = ContextCompat.getDrawable(context, R.drawable.recyclerview_line_divider);
        } else {
            mDivider = divider;
        }
        mDividerHeight = dp2px(context, dividerHeight);
    }

    /**
     * dp单位转换成px
     *
     * @param context 上下文
     * @param dpValue dp的值
     * @return px的值
     */
    private static int dp2px(Context context, final float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    //获取分割线尺寸
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.set(0, 0, 0, mDividerHeight);
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();

        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);

            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();

            int top = child.getBottom() + params.bottomMargin;
            int bottom = top + mDividerHeight;
            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(c);
        }

    }
}