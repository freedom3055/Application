package com.example.circleimageview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;
import android.widget.ImageView;

public class CircleImageView extends ImageView {
    public CircleImageView(Context context) {
        super(context);
    }

    public CircleImageView(Context context,  AttributeSet attrs) {
        super(context, attrs);
    }

    public CircleImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(getMeasuredWidth(),getMeasuredWidth());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Path path = new Path();
        float radius = getMeasuredWidth()/2.0f;
        path.addCircle(radius,radius,radius,Path.Direction.CCW);
        canvas.clipPath(path);
        super.onDraw(canvas);
    }
}
