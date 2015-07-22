package com.soujuw.android.partner.Views;

/**
 * Created by Administrator on 2015/7/16.
 */

import android.content.Context;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.AttributeSet;

import com.rengwuxian.materialedittext.validation.METValidator;

public class VerifyCodeEdit extends AnimatedEditText implements TextWatcher {
    public VerifyCodeEdit(Context context) {
        super(context);
        init();
    }

    public VerifyCodeEdit(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public VerifyCodeEdit(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    protected void init() {
        this.setSingleLine(true);
        this.setInputType(InputType.TYPE_CLASS_NUMBER);
        this.setHelperText("请输入手机验证码");
        this.setMaxCharacters(6);
        addValidator(new METValidator("验证码应该是6位") {
            @Override
            public boolean isValid(CharSequence charSequence, boolean isEmpty) {
                return charSequence.length() == 6;
            }
        });
        addTextChangedListener(this);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//        super.onTextChanged(s,start,count,after);
    }

    @Override
    public void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
//        super.onTextChanged(text,start,lengthBefore,lengthAfter);
    }

    @Override
    public void afterTextChanged(Editable s) {
        //Log.d("PET","afterTextChanged(" + s + "," + Integer.toString(count) + ", " + Integer.toString(before) + Integer.toString(start) + ", " + ")");

        if (s.length() > 6) {
            s.delete(6, s.length());
        }
    }
}
