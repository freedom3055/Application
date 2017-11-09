package com.example.your.settingitems.base;

import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by Your on 2017/11/7.
 */

public abstract class SettingsItem {
    private final LayoutInflater inflater;
    private View view;
    public SettingsItem(LayoutInflater inflater){
        this.inflater = inflater;
    }
    public View getView(){
        if (view == null){
            view = inflater.inflate(getLayoutId(),null);
            initView(view);
        }
        return view;
    }
    public abstract void initView(View view);
    public abstract int getLayoutId();
    public abstract boolean isEnabled();
    public abstract void onClick(View view);
}
