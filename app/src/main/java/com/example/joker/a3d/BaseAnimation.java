package com.example.joker.a3d;

import android.animation.AnimatorSet;
import android.view.View;
import android.view.animation.Interpolator;

public abstract class BaseAnimation {
    protected AnimatorSet mAnimatorSet = new AnimatorSet();
    private long mDuration = 500;
    private Interpolator mInterpolator = null;

    public abstract void setAnimator(View correct, View next);

    public abstract void setDefault(View correct, View next);

    public void reset(View correct, View next) {
        correct.setRotation(0);
        correct.setRotationX(0);
        correct.setRotationY(0);
        next.setRotation(0);
        next.setRotationX(0);
        next.setRotationY(0);
    }

    private void startAnimation() {
        if (mInterpolator != null) {
            mAnimatorSet.setInterpolator(mInterpolator);
        }
        mAnimatorSet.setDuration(mDuration);
        mAnimatorSet.start();
    }

    public long getDuration() {
        return mDuration;
    }

    public void setDuration(long duration) {
        mDuration = duration;
    }

    public void playOn() {
        startAnimation();
    }

    public Interpolator getInterpolator() {
        return mInterpolator;
    }

    public void setInterpolator(Interpolator interpolator) {
        mInterpolator = interpolator;
    }

    public boolean isRunning() {
        return mAnimatorSet.isRunning();
    }
}
