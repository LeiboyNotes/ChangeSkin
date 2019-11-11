package com.zl.skinlibrary.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

import com.zl.skinlibrary.R;
import com.zl.skinlibrary.ViewsChange;
import com.zl.skinlibrary.bean.AttrsBean;

import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;

public class ZlButton extends AppCompatButton implements ViewsChange {

    private AttrsBean attrsBean;

    public ZlButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ZlButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        attrsBean = new AttrsBean();
        //临时存储
        TypedArray typedArray =
                context.obtainStyledAttributes(attrs, R.styleable.ZlButton, defStyleAttr, 0);
        attrsBean.saveViewResource(typedArray, R.styleable.ZlButton);
        //性能优化  回收
        typedArray.recycle();

    }

    @Override
    public void skinChangeAction() {

        int key = R.styleable.ZlButton[R.styleable.ZlButton_android_background];
        int backgroundID = attrsBean.getViewResource(key);
        if (backgroundID > 0) {
            //使用兼容包
            Drawable drawable = ContextCompat.getDrawable(getContext(), backgroundID);
            setBackgroundDrawable(drawable);

        }

        key = R.styleable.ZlButton[R.styleable.ZlButton_android_textColor];
        int textColorID = attrsBean.getViewResource(key);
        if (textColorID > 0) {
            //使用兼容包
            ColorStateList color = ContextCompat.getColorStateList(getContext(), textColorID);
            setTextColor(color);

        }
    }
}
