package com.zl.skinlibrary.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

import com.zl.skinlibrary.R;
import com.zl.skinlibrary.ViewsChange;
import com.zl.skinlibrary.bean.AttrsBean;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.content.ContextCompat;

public class ZlLinearLayout extends LinearLayoutCompat implements ViewsChange {

    private AttrsBean attrsBean;

    public ZlLinearLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ZlLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        attrsBean = new AttrsBean();
        //临时存储
        TypedArray typedArray =
                context.obtainStyledAttributes(attrs, R.styleable.ZlLinearLayout, defStyleAttr, 0);
        attrsBean.saveViewResource(typedArray, R.styleable.ZlLinearLayout);
        //性能优化  回收
        typedArray.recycle();

    }

    @Override
    public void skinChangeAction() {

        int key = R.styleable.ZlLinearLayout[R.styleable.ZlLinearLayout_android_background];
        int backgroundID = attrsBean.getViewResource(key);
        if (backgroundID > 0) {
            //使用兼容包
            Drawable drawable = ContextCompat.getDrawable(getContext(), backgroundID);
            setBackground(drawable);

        }

    }
}