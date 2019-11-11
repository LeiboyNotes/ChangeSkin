package com.zl.skin;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;

import com.zl.skinlibrary.SkinActivity;

import androidx.appcompat.app.AppCompatDelegate;


public class MainActivity extends SkinActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean openSkin() {
        return true;
    }

    //切换白天黑夜模式
    public void dayOrNight(View view) {
        int uiMode = getResources().getConfiguration().uiMode& Configuration.UI_MODE_NIGHT_MASK;

        switch (uiMode){
            case Configuration.UI_MODE_NIGHT_NO:
                setDayNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                break;
            case Configuration.UI_MODE_NIGHT_YES:
                setDayNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                break;
        }
    }
}
