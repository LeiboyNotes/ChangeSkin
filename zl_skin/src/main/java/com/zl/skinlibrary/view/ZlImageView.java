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
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;

public class ZlImageView extends AppCompatImageView implements ViewsChange {

    private AttrsBean attrsBean;

    public ZlImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ZlImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        attrsBean = new AttrsBean();
        //临时存储
        TypedArray typedArray =
                context.obtainStyledAttributes(attrs, R.styleable.ZlImageView, defStyleAttr, 0);
        attrsBean.saveViewResource(typedArray, R.styleable.ZlImageView);
        //性能优化  回收
        typedArray.recycle();

    }

    @Override
    public void skinChangeAction() {

        int key = R.styleable.ZlImageView[R.styleable.ZlImageView_android_src];
        int srcID = attrsBean.getViewResource(key);
        if (srcID > 0) {
            //使用兼容包
            Drawable drawable = ContextCompat.getDrawable(getContext(), srcID);
            setImageDrawable(drawable);

        }

    }
}