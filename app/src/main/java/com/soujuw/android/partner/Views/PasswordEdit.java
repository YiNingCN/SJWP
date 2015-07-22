package com.soujuw.android.partner.Views;

/**
 * Created by Administrator on 2015/7/16.
 */

import android.content.Context;
import android.util.AttributeSet;

public class PasswordEdit extends AnimatedEditText {
    public PasswordEdit(Context context) {
        super(context);
        init();
    }

    public PasswordEdit(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PasswordEdit(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    protected void init() {
        //setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
        this.setMaxCharacters(20);
    }


}
