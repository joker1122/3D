package com.example.joker.a3d;

import android.content.Context;
import android.util.Log;

public class ChangeUnits {
    public static float change(Context context, int px) {
        float dp;
        dp = px / context.getResources().getDisplayMetrics().density;
//        Log.d("joker", "px is " + px + "density is " + context.getResources().getDisplayMetrics().density + "dp is " + dp);
        return dp;
    }
}
