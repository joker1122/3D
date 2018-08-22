package com.example.joker.a3d;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.util.Log;
import android.view.View;

public class RightAnimation extends BaseAnimation {
    @Override
    public void setAnimator(View correct, View next) {
        setDefault(correct, next);
        PropertyValuesHolder correctPosition = PropertyValuesHolder.ofFloat("translationX", 0, ChangeUnits.change(correct.getContext(), correct.getWidth()));
        PropertyValuesHolder nextPosition = PropertyValuesHolder.ofFloat("translationX", ChangeUnits.change(next.getContext(), -next.getWidth()), 0);
        PropertyValuesHolder correctDegree = PropertyValuesHolder.ofFloat("rotationY", 0, 90);
        PropertyValuesHolder nextDegree = PropertyValuesHolder.ofFloat("rotationY", 270, 360);
        mAnimatorSet.playTogether(ObjectAnimator.ofPropertyValuesHolder(correct, correctPosition, correctDegree)
                , ObjectAnimator.ofPropertyValuesHolder(next, nextPosition, nextDegree));
    }

    @Override
    public void setDefault(View correct, View next) {
        next.setRotationY(270);
        next.setTranslationY(0);
        correct.setTranslationY(0);
    }
}
