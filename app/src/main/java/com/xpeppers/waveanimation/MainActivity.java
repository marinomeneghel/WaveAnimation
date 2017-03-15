package com.xpeppers.waveanimation;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private Handler handler;
    private View[] views;
    private double duration = 400;
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
            updateTime();
        }
    };

    private void updateTime() {
        for (int i = 0; i < views.length; i++) {
            animate(views[i], i);
            handler.postDelayed(runnable, (long) (duration * 3));
        }
    }

    private void animate(View view, int index) {
        scaleUp(view, index);
        scaleDown(view, index);
    }

    private void scaleUp(View view, int index) {
        int delay = (int) ((index * phaseShift) + duration);
        
    }

    private void scaleDown(View view, int index) {
        view.animate().scaleY(10f);
    }
}
