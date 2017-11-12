package com.example.thememanager;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;

import com.example.thememanager.theme.Theme;
import com.example.thememanager.theme.ThemeManager;

public class SwitchThemeActivity extends Activity {

    private ImageView imageView;
    private CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        imageView = findViewById(R.id.imageView);
        ThemeManager.getInstance(this).setImageDrawable(imageView,"ic_android_black_24dp");

        checkBox = findViewById(R.id.checkBox);
        ThemeManager.getInstance(this).setTextColor(checkBox);

        checkBox.setText(Theme.DEFAULT.name());
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    ThemeManager.getInstance(SwitchThemeActivity.this).setTheme(Theme.RED);
                    checkBox.setText(Theme.RED.name());
                }else {
                    ThemeManager.getInstance(SwitchThemeActivity.this).setTheme(Theme.DEFAULT);
                    checkBox.setText(Theme.DEFAULT.name());
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ThemeManager.releaseThemeManager();
    }
}
