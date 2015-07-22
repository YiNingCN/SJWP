package com.soujuw.android.partner.Views;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;

/**
 * Created by YiNing on 2015/7/19.
 */
public class CardBase extends CardView {
    public CardBase(Context context) {
        super(context);
        init(context);
    }

    public CardBase(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CardBase(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    void init(Context context) {

    }
}
