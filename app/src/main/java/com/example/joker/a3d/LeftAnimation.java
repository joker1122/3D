package com.example.joker.a3d;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.util.Log;
import android.view.View;

public class LeftAnimation extends BaseAnimation {
    @Override
    public void setDefault(View correct, View next) {
        next.setRotationY(270);
        next.setTranslationY(0);
        correct.setTranslationY(0);
    }

    @Override
    public void setAnimator(View correct, View next) {
        setDefault(correct, next);
        PropertyValuesHolder correctPosition = PropertyValuesHolder.ofFloat("translationX", 0, ChangeUnits.change(correct.getContext(), -correct.getWidth()));
        PropertyValuesHolder nextPosition = PropertyValuesHolder.ofFloat("translationX", ChangeUnits.change(next.getContext(), next.getWidth()), 0);
        PropertyValuesHolder correctDegree = PropertyValuesHolder.ofFloat("rotationY", 180, 90);
        PropertyValuesHolder nextDegree = PropertyValuesHolder.ofFloat("rotationY", 270, 180);
        mAnimatorSet.playTogether(
                ObjectAnimator.ofPropertyValuesHolder(correct, correctDegree, correctPosition)
                , ObjectAnimator.ofPropertyValuesHolder(next, nextDegree, nextPosition)
        );
    }
}
