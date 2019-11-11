package com.zl.skinlibrary;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zl.skinlibrary.utils.ActionBarUtils;
import com.zl.skinlibrary.utils.NavigationUtils;
import com.zl.skinlibrary.utils.StatusBarUtils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.LayoutInflaterCompat;

public class SkinActivity extends AppCompatActivity {

    private MyAppCompatViewInflater viewInflater;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        LayoutInflaterCompat.setFactory2(LayoutInflater.from(this),this);
        super.onCreate(savedInstanceState);
    }


    @Nullable
    @Override
    public View onCreateView(@Nullable View parent, @NonNull String name, @NonNull Context context, @NonNull AttributeSet attrs) {

        if (openSkin()) {
            if (null == viewInflater) {
                viewInflater = new MyAppCompatViewInflater(context);
            }
            viewInflater.setName(name);
            viewInflater.setAttrs(attrs);
            return viewInflater.createViewAction();//如果返回null，系统判断是null，就会走系统的，不影响
        }

        return super.onCreateView(parent ,name, context, attrs);//继续正常走系统
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull String name, @NonNull Context context, @NonNull AttributeSet attrs) {


    }

    //默认关闭换肤功能
    public boolean openSkin(){
        return false;
    }

    //TODO  暴露给使用者使用， 换肤操作（内置换肤   没有皮肤包  黑夜和白天）
    public void setDayNightMode(int mode){
        getDelegate().setLocalNightMode(mode);//兼容包提供了  黑夜白天模式
        final boolean isPost21 = Build.VERSION.SDK_INT>=21;
        if (isPost21) {
            StatusBarUtils.forStatusBar(this);//改变状态栏颜色
            ActionBarUtils.forActionBar(this);//标题栏
            NavigationUtils.forNavigation(this);//虚拟按键导航栏
        }
        View decorView = getWindow().getDecorView();
        changeSkinAction(decorView);
    }

    //使用递归+接口回调方式  换肤
    private void changeSkinAction(View decorView){

        if (decorView instanceof ViewsChange) {//成为ViewsChange标准
            ViewsChange viewsChange = (ViewsChange) decorView;
            viewsChange.skinChangeAction();
        }

        if (decorView instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) decorView;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                changeSkinAction(viewGroup.getChildAt(i));
            }
        }
    }

}
