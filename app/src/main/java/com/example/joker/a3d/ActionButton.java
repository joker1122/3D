package com.example.joker.a3d;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;

public class ActionButton extends AppCompatButton {
    private int mT;

    public ActionButton(Context context) {
        super(context);
    }

    public ActionButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        final TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ActionButton);
        mT = typedArray.getInt(R.styleable.ActionButton_tag, -1);
    }

    public ActionButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public int getT() {
        return mT;
    }

    public void setT(int t) {
        mT = t;
    }
}
