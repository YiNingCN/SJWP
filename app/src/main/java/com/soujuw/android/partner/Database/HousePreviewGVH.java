package com.soujuw.android.partner.Database;

import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.h6ah4i.android.widget.advrecyclerview.utils.AbstractExpandableItemViewHolder;
import com.soujuw.android.partner.R;

/**
 * 二手房浏览卡VH
 */
public class HousePreviewGVH extends AbstractExpandableItemViewHolder {
    CardView vCard;
    LinearLayout vRoot;
    ImageView vImage;
    TextView vImageCount, vTitle, vDistance, vLoacation, vPrice, vSubPrice;

    public HousePreviewGVH(View v) {
        super(v);
        vCard = (CardView) v.findViewById(R.id.card_view);
        vRoot = (LinearLayout) v.findViewById(R.id.container);
        vImage = (ImageView) v.findViewById(R.id.preview_item_picture);
        vImageCount = (TextView) v.findViewById(R.id.preview_item_picture_count);
        vTitle = (TextView) v.findViewById(R.id.preview_item_title);
        vDistance = (TextView) v.findViewById(R.id.preview_item_distance);
        vPrice = (TextView) v.findViewById(R.id.preview_item_main_price);
        vSubPrice = (TextView) v.findViewById(R.id.preview_item_sub_price);
        vLoacation = (TextView) v.findViewById(R.id.preview_item_location);
    }
}
