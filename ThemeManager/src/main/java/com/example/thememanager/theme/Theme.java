package com.example.thememanager.theme;

import android.graphics.Color;

/**
 * Created by Your on 2017/11/12.
 */

public enum Theme {
    DEFAULT{
        @Override
        public String getResourceSubfix() {
            return "_default";
        }
    },
    RED{
        @Override
        public String getResourceSubfix() {
            return "_red";
        }

        @Override
        public int getTextColor() {
            return Color.RED;//super.getTextColor();
        }
    };
    public abstract String getResourceSubfix();
    public int getTextColor(){
        return Color.BLACK;
    }

}
