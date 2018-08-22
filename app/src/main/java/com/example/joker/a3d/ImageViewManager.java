package com.example.joker.a3d;

import android.view.View;

public class ImageViewManager<T extends View> implements ActionInterface {
    private static ImageViewManager INSTANCE;
    public static final int ACTION_LEFT = 1;
    public static final int ACTION_UP = 2;
    public static final int ACTION_RIGHT = 3;
    public static final int ACTION_DOWN = 4;
    private BaseAnimation mBaseAnimation = null;
    private BitmapManageImpl mBitmapManage;
    private T mCorrectView;
    private T mNextView;
    private int mCorrectAction = -1;

    private ImageViewManager() {
        mBitmapManage = new BitmapManageImpl();
    }

    public static synchronized ImageViewManager getINSTANCE() {
        if (null == INSTANCE) {
            INSTANCE = new ImageViewManager();
        }
        return INSTANCE;
    }

    @Override
    public void setAnimator() {
        switch (mCorrectAction) {
            case ACTION_LEFT:
                mBaseAnimation = new LeftAnimation();
                break;
            case ACTION_UP:
                mBaseAnimation = new UpAnimation();
                break;
            case ACTION_RIGHT:
                mBaseAnimation = new RightAnimation();
                break;
            case ACTION_DOWN:
                mBaseAnimation = new DownAnimation();
                break;
            default:
                break;
        }
    }

    public View getCorrectView() {
        return mCorrectView;
    }

    public void setCorrectView(T correctView) {
        mCorrectView = correctView;
    }

    public View getNextView() {
        return mNextView;
    }

    public void setNextView(T nextView) {
        mNextView = nextView;
    }

    public int getCorrectAction() {
        return mCorrectAction;
    }

    public void setCorrectAction(int correctAction) {
        if (null != mBaseAnimation && isRunning()) {
            return;
        }
        if (mCorrectAction == -1) {
        } else if (mCorrectAction % 2 != correctAction % 2) {
            mBaseAnimation.reset(mCorrectView, mNextView);
        }
        mCorrectAction = correctAction;
        setAnimator();
    }

    @Override
    public void playAnimator() {
        mBaseAnimation.setAnimator(mCorrectView, mNextView);
        mBaseAnimation.playOn();
        changeView();
    }

    @Override
    public void changeView() {
        T tag = mCorrectView;
        mCorrectView = mNextView;
        mNextView = tag;
    }

    private boolean isRunning() {
        return mBaseAnimation.isRunning();
    }
}
