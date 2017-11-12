package com.example.thememanager.theme;

import android.content.Context;
import android.content.res.Resources;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Your on 2017/11/12.
 */

public final class ThemeManager {
    private static ThemeManager themeManger;
    private final Context context;
    private final Resources resources;
    private final String packageName;
    private Theme theme = Theme.DEFAULT;
    private Map<String,WeakReference<ImageView>> themeImages = new HashMap<>();
    private Set<WeakReference<TextView>> themeTextViews = new HashSet<>();

    public void setTheme(Theme theme) {
        if (this.theme.compareTo(theme) != 0){
            this.theme = theme;
            switchImageTheme();
            switchTextTheme();
        }
    }


    private ThemeManager(Context context) {
        this.context = context;
        this.resources = context.getResources();
        this.packageName = context.getPackageName();
    }

    public static ThemeManager getInstance(Context context) {
        if (themeManger == null) {
            themeManger = new ThemeManager(context.getApplicationContext());
        }
        return themeManger;
    }
    public static void releaseThemeManager(){
        themeManger = null;
    }

    public void setImageDrawable(ImageView imageView,String resName){
        String resId = String.format("%s%s", resName, theme.getResourceSubfix());
        int id = context.getResources().getIdentifier(resId, "drawable", packageName);
        if (id != 0){
            imageView.setImageResource(id);
            themeImages.put(resName,new WeakReference<ImageView>(imageView));
        }
    }
    private void switchImageTheme(){
        for (String resName : themeImages.keySet()){
            ImageView imageView = themeImages.get(resName).get();
            if (imageView != null){
                String resId = String.format("%s%s", resName, theme.getResourceSubfix());
                int id = context.getResources().getIdentifier(resId, "drawable", packageName);
                if (id != 0){
                    imageView.setImageResource(id);
                }
            }
        }
    }
    public void setTextColor(TextView textView){
        textView.setTextColor(theme.getTextColor());
        themeTextViews.add(new WeakReference(textView));
    }
    private void switchTextTheme(){
        for(WeakReference<TextView> rs :themeTextViews){
            TextView textView = rs.get();
            if (textView != null){
                textView.setTextColor(theme.getTextColor());
            }
        }
    }
}
