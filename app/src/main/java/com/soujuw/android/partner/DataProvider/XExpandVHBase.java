package com.soujuw.android.partner.DataProvider;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.h6ah4i.android.widget.advrecyclerview.utils.AbstractExpandableItemViewHolder;
import com.soujuw.android.partner.R;

/**
 * 可扩展的ViewHolder基类。所有用于显示的列表项需要提供相同的结构
 * container.容器.
 */


public abstract class XExpandVHBase extends AbstractExpandableItemViewHolder {
    public FrameLayout mContainer;
    public View mDragHandle;
    public TextView mTextView;

    public XExpandVHBase(View v) {
        super(v);
        mContainer = (FrameLayout) v.findViewById(R.id.container);
        mTextView = (TextView) v.findViewById(android.R.id.text1);

        //no support for dragging
        //mDragHandle = v.findViewById(R.id.drag_handle);
        //mDragHandle.setVisibility(View.GONE);
    }
}
