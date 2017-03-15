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
                final int finalI = i;
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.waves_animation);
                        views[finalI].startAnimation(animation);
                    }
                }, 300 * finalI);
            }
            handler.postDelayed(this, (long) (duration * 3 + stopDelay));
        }
    };


}
