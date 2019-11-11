package com.zl.skinlibrary.bean;

import android.content.res.TypedArray;
import android.util.SparseIntArray;

public class AttrsBean {

    private SparseIntArray sparseIntArray;

    private static final int DEFAULT_VALUE = -1;

    public AttrsBean() {
        this.sparseIntArray = new SparseIntArray();
    }


    //保存属性集合
    public void saveViewResource(TypedArray typedArray, int[] styleable) {
        for (int i = 0; i < typedArray.length(); i++) {
            int key = styleable[i];
            int resourceId = typedArray.getResourceId(i, DEFAULT_VALUE);


        }
    }

    //get属性集合
    public int getViewResource(int styleable) {
        return sparseIntArray.get(styleable);
    }
}
