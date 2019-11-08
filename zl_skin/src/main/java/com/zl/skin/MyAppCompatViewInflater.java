package com.zl.skin;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

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
                break;
            case "ImageView":
                break;
            case "Button":
                break;
            case "EditText":
                break;
            case "LinearLayout":
                break;
            case "RelativeLayout":
                break;
        }

        return resultView;
    }
}
