package com.example.your.settingitems.items;

import android.view.LayoutInflater;
import android.view.View;

import com.example.your.settingitems.R;
import com.example.your.settingitems.base.SettingsItem;

/**
 * Created by Your on 2017/11/7.
 */

public class SettingsEmpty extends SettingsItem {

    public SettingsEmpty(LayoutInflater inflater) {
        super(inflater);
    }

    @Override
    public void initView(View view) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.setting_empty_item;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public void onClick(View view) {

    }
}
