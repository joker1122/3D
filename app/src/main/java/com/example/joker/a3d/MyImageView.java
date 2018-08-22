package com.example.joker.a3d;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;

public class MyImageView extends AppCompatImageView {
    private int mCorrectWidth = -1;
    private int mCorrectHeight = -1;

    public MyImageView(Context context) {
        super(context);
    }

    public MyImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (mCorrectHeight != -1) {
            setMeasuredDimension(mCorrectWidth, mCorrectHeight);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public void reMeasure(float widthPercent, float heightPercent) {
        mCorrectWidth = (int) (getMeasuredWidth() * widthPercent);
        mCorrectHeight = (int) (getMeasuredHeight() * heightPercent);
        requestLayout();
    }
}
