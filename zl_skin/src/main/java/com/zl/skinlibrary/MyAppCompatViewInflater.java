package com.zl.skinlibrary;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import com.zl.skinlibrary.view.ZlButton;
import com.zl.skinlibrary.view.ZlImageView;
import com.zl.skinlibrary.view.ZlLinearLayout;
import com.zl.skinlibrary.view.ZlRelativeLayout;
import com.zl.skinlibrary.view.ZlTextView;

public class MyAppCompatViewInflater {

    private Context context;
    private String name;//控件名  TextView  Button ...
    private AttributeSet attrs;//控件对应的属性集合


    public MyAppCompatViewInflater(Context context) {
        this.context = context;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAttrs(AttributeSet attrs) {
        this.attrs = attrs;
    }

    public View createViewAction(){
        View resultView = null;
        switch (name){
            case "TextView":
                resultView = new ZlTextView(context,attrs);
                break;
            case "ImageView":
                resultView = new ZlImageView(context,attrs);
                break;
            case "Button":
                resultView = new ZlButton(context,attrs);
                break;
            case "LinearLayout":
                resultView = new ZlLinearLayout(context,attrs);
                break;
            case "RelativeLayout":
                resultView = new ZlRelativeLayout(context,attrs);
                break;
        }

        return resultView;
    }
}
