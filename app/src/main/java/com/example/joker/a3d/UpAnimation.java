package com.example.joker.a3d;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.util.Log;
import android.view.View;

public class UpAnimation extends BaseAnimation {
    @Override
    public void setAnimator(View correct, View next) {
        setDefault(correct, next);
        PropertyValuesHolder correctPosition = PropertyValuesHolder.ofFloat("translationY", 0, ChangeUnits.change(correct.getContext(), -correct.getHeight()));
        PropertyValuesHolder nextPosition = PropertyValuesHolder.ofFloat("translationY", ChangeUnits.change(next.getContext(), next.getHeight()), 0);
        PropertyValuesHolder correctDegree = PropertyValuesHolder.ofFloat("rotationX", 0, 90);
        PropertyValuesHolder nextDegree = PropertyValuesHolder.ofFloat("rotationX", 270, 360);
        mAnimatorSet.playTogether(ObjectAnimator.ofPropertyValuesHolder(correct, correctPosition, correctDegree)
                , ObjectAnimator.ofPropertyValuesHolder(next, nextPosition, nextDegree));
    }

    @Override
    public void setDefault(View correct, View next) {
        next.setRotationX(270);
        next.setTranslationX(0);
        correct.setTranslationX(0);
    }

}
