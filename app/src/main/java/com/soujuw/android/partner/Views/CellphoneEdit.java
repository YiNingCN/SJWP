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

public class CellphoneEdit extends AnimatedEditText implements TextWatcher {
    public CellphoneEdit(Context context) {
        super(context);

        init();
    }

    public CellphoneEdit(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CellphoneEdit(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    protected void init() {
        this.setSingleLine(true);
        this.setInputType(InputType.TYPE_CLASS_NUMBER);
        this.setHelperText("请输入11位手机号码");
        this.setMaxCharacters(11);
        this.setValidateOnFocusLost(true);
        addValidator(new METValidator("手机号码应该是11位") {
            @Override
            public boolean isValid(CharSequence charSequence, boolean isEmpty) {
                if (isEmpty)
                    return true;
                int nLen = charSequence.length();
                return nLen == 0 || nLen == 11;
            }
        });
        addValidator(new METValidator("手机号码格式错误") {
            @Override
            public boolean isValid(CharSequence charSequence, boolean isEmpty) {
                if(isEmpty)
                    return true;
                return charSequence.charAt(0) == '1' && charSequence.charAt(1) > '2' && charSequence.charAt(1) <= '9';
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

        if (s.length() > 11) {
            s.delete(11, s.length());
        }
    }
}
