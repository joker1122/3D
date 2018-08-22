package com.example.joker.a3d;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private ImageViewManager mImageViewManager;
    private View mCorrectImage;
    private View mNextImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCorrectImage = findViewById(R.id.image);
        mNextImage = findViewById(R.id.image_next);
        mImageViewManager = ImageViewManager.getINSTANCE();
        mImageViewManager.setCorrectView(mCorrectImage);
        mImageViewManager.setNextView(mNextImage);
        mCorrectImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MyImageView) mCorrectImage).reMeasure(0.9f, 0.9f);
            }
        });
        mNextImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MyImageView) mNextImage).reMeasure(0.9f, 0.9f);
            }
        });
        findViewById(R.id.bt_left).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mImageViewManager.setCorrectAction(ImageViewManager.ACTION_LEFT);
                mImageViewManager.playAnimator();
            }
        });
        findViewById(R.id.bt_up).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mImageViewManager.setCorrectAction(ImageViewManager.ACTION_UP);
                mImageViewManager.playAnimator();
            }
        });
        findViewById(R.id.bt_right).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mImageViewManager.setCorrectAction(ImageViewManager.ACTION_RIGHT);
                mImageViewManager.playAnimator();
            }
        });
        findViewById(R.id.bt_down).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mImageViewManager.setCorrectAction(ImageViewManager.ACTION_DOWN);
                mImageViewManager.playAnimator();
            }
        });
    }
}
