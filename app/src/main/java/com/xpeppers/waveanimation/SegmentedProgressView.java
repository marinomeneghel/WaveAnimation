package com.xpeppers.waveanimation;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

public class SegmentedProgressView extends LinearLayout {

    private final Handler handler;
    private View[] bars;
    private long phaseShift = 100;
    private long duration = 400;
    private long stopDelay = 1400;

    public SegmentedProgressView(Context context) {
        super(context);
        initView(context);
        handler = new Handler();
    }

    public SegmentedProgressView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
        handler = new Handler();
    }

    public SegmentedProgressView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
        handler = new Handler();
    }

    private void initView(Context context) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.waves_layout, this, true);
        bars = new View[]{
                findViewById(R.id.firstView),
                findViewById(R.id.secondView),
                findViewById(R.id.thirdView),
                findViewById(R.id.fourthView),
                findViewById(R.id.fifthView)
        };
    }

    public void startAnimation() {
        handler.postDelayed(runnable, duration * 3);
    }

    private void animate(final View view, final int index) {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                view.startAnimation(loadAnimationFromRes());
            }
        }, phaseShift * index);
    }

    private Animation loadAnimationFromRes() {
        return AnimationUtils.loadAnimation(getContext(), R.anim.waves_animation);
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            for (int i = 0; i < bars.length; i++) {
                View view = bars[i];
                animate(view, i);
            }
            handler.postDelayed(this, duration * 3 + stopDelay);
        }
    };

}