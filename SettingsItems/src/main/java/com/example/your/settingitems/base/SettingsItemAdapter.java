package com.example.your.settingitems.base;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by Your on 2017/11/7.
 */

public class SettingsItemAdapter extends BaseAdapter {
    private final List<SettingsItem> settingsItems;
    public SettingsItemAdapter(List<SettingsItem> settingsItems) {
        this.settingsItems = settingsItems;
    }

    @Override
    public int getCount() {
        return settingsItems.size();
    }

    @Override
    public Object getItem(int i) {
        return settingsItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return settingsItems.get(i).getView();
    }

    @Override
    public boolean isEnabled(int position) {
        //return super.isEnabled(position);
        return settingsItems.get(position).isEnabled();
    }
}
