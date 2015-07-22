package com.soujuw.android.partner.Views;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;

import com.daimajia.androidanimations.library.attention.ShakeAnimator;
import com.rengwuxian.materialedittext.MaterialEditText;

/**
 * Created by YiNing on 2015/7/21.
 */
public abstract class AnimatedEditText extends MaterialEditText {
    public AnimatedEditText(Context context) {
        super(context);
    }

    public AnimatedEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AnimatedEditText(Context context, AttributeSet attrs, int style) {
        super(context, attrs, style);
    }

    public void askForCorrection() {
        new ShakeAnimator().setDuration(700).animate(this);
    }

    public void askForCorrection(@NonNull CharSequence errorText) {
        setError(errorText);
        askForCorrection();
    }

    public boolean isEmpty() {
        return getText().length() == 0;
    }
}
