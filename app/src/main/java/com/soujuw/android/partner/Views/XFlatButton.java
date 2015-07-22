package com.soujuw.android.partner.Views;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.daimajia.easing.Glider;
import com.daimajia.easing.Skill;
import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.animation.ValueAnimator;
import com.rey.material.widget.CompoundButton;

/**
 * 用CardView包含一个CompondButton实现浮起和卡片双重效果.
 */
public class XFlatButton extends CompoundButton {

    CardView parentCard;
    float elevation;
    ValueAnimator anim;

    public XFlatButton(Context context) {
        super(context);
    }

    public XFlatButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public XFlatButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    boolean prepare() {
        if (parentCard == null) {
            if (getParent() instanceof CardView)
                parentCard = (CardView) getParent();
            else
                return false;
        }
        elevation = parentCard.getCardElevation();
        if (anim != null)
            anim.cancel();
        return true;
    }

    //抬起卡片
    void liftUp() {
        if (!prepare())
            return;
        if (elevation == 8)
            return;
//        AnimatorSet set = new AnimatorSet();
//        set.playTogether(
        anim = Glider.glide(Skill.QuadEaseOut, (long) (8f - elevation * 50), ObjectAnimator.ofFloat(parentCard, "cardElevation", elevation, 8f));
        anim.start();

    }

    //放下卡片
    void putDown() {
        if (!prepare())
            return;
        if (elevation == 0)
            return;
        anim = Glider.glide(Skill.QuadEaseOut, (long) (elevation * 50), ObjectAnimator.ofFloat(parentCard, "cardElevation", elevation, 0f));
        anim.start();
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (getParent() instanceof CardView) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    //case MotionEvent.ACTION_HOVER_ENTER:
                    liftUp();
                    break;
                case MotionEvent.ACTION_UP:
                case MotionEvent.ACTION_HOVER_EXIT:
                    putDown();
                    break;
                default:
                    break;
            }
        }

        return super.onTouchEvent(event);
    }
}
