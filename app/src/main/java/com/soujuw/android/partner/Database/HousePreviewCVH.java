package com.soujuw.android.partner.Database;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.h6ah4i.android.widget.advrecyclerview.utils.AbstractExpandableItemViewHolder;
import com.soujuw.android.partner.R;

/**
 * 二手房浏览卡-扩展VH
 */
public class HousePreviewCVH extends AbstractExpandableItemViewHolder {
    //CardView card;
    LinearLayout vRoot;
    TextView vText;

    public HousePreviewCVH(View v) {
        super(v);
        //card = (CardView)v.findViewById(R.id.card_view);
        vRoot = (LinearLayout) v.findViewById(R.id.container);
        vText = (TextView) v.findViewById(R.id.expand_item_text);
    }
}
