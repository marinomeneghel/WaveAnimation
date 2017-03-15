package com.xpeppers.waveanimation;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class MainActivity extends AppCompatActivity {

    private Handler handler;
    private View[] views;
    private double duration = 400;
    private double stopDelay = 600;
    private double phaseShift = 0.1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        views = new View[]{
                findViewById(R.id.firstView),
                findViewById(R.id.secondView),
                findViewById(R.id.thirdView),
                findViewById(R.id.fourthView),
                findViewById(R.id.fifthView)
        };

        handler = new Handler();
        handler.postDelayed(runnable, (long) (duration * 3));

    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            for (int i = 0; i < views.length; i++) {
                View view = views[i];
                animate(view, i);
            }
            handler.postDelayed(this, (long) (duration * 3 + stopDelay));
        }
    };

    private void animate(final View view, final int index) {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                view.startAnimation(loadAnimationFromRes());
            }
        }, 300 * index);
    }

    private Animation loadAnimationFromRes() {
        return AnimationUtils.loadAnimation(getApplicationContext(), R.anim.waves_animation);
    }


}
