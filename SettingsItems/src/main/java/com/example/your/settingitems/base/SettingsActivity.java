package com.example.your.settingitems.base;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;

import com.example.your.settingitems.items.SettingsEmpty;
import com.example.your.settingitems.items.SettingsLabel;
import com.example.your.settingitems.items.SettingsSwitch;

import java.util.ArrayList;
import java.util.List;

public class SettingsActivity extends ListActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        List<SettingsItem> items = new ArrayList<>();
        LayoutInflater inflater = LayoutInflater.from(this);
        items.add(new SettingsLabel(inflater));
        items.add(new SettingsLabel(inflater));
        items.add(new SettingsEmpty(inflater));
        items.add(new SettingsLabel(inflater));
        items.add(new SettingsSwitch(inflater));
        items.add(new SettingsLabel(inflater));


        ListAdapter adapter = new SettingsItemAdapter(items);
        getListView().setAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        ((SettingsItem)getListView().getAdapter().getItem(i)).onClick(view);
    }
}
