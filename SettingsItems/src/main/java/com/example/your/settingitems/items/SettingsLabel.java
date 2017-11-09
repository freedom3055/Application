package com.example.your.settingitems.items;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.example.your.settingitems.R;
import com.example.your.settingitems.base.SettingsItem;

/**
 * Created by Your on 2017/11/7.
 */

public class SettingsLabel extends SettingsItem {


    public SettingsLabel(LayoutInflater inflater) {
        super(inflater);
    }

    @Override
    public void initView(View view) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.setting_label_item;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(view.getContext(), this.toString(), Toast.LENGTH_LONG).show();
    }
}
