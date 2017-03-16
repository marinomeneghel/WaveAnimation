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

    private static final long PHASE_SHIFT = 100;
    private static final long DURATION = 400;
    private static final long STOP_DELAY = 1400;

    private final Handler handler;
    private View[] bars;

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

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        for (View bar : bars) {
            int currentHeight = bar.getMeasuredHeight();
            bar.getLayoutParams().height = currentHeight / 3;
            bar.invalidate();
        }
    }

    public void startAnimation() {
        handler.postDelayed(runnable, DURATION * 3);
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

    private void animate(final View view, final int index) {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                view.startAnimation(loadAnimationFromRes());
            }
        }, PHASE_SHIFT * index);
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
            handler.postDelayed(this, DURATION * 3 + STOP_DELAY);
        }
    };

}
