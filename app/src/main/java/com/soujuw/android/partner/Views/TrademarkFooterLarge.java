package com.soujuw.android.partner.Views;

import android.content.Context;
import android.support.v4.view.LayoutInflaterCompat;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.soujuw.android.partner.R;

/**
 * Created by YiNing on 2015/7/18.
 */
public class TrademarkFooterLarge extends LinearLayout {

    public TrademarkFooterLarge(Context context) {
        super(context);
        init(context);
    }

    public TrademarkFooterLarge(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public TrademarkFooterLarge(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context){
        LayoutInflater mInflater = LayoutInflater.from(context);
        View myView = mInflater.inflate(R.layout.trademark_pagefooter, this, true);
        //addView(myView);
    }
}
