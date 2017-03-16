package com.xpeppers.waveanimation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private SegmentedProgressView spvLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spvLoader = (SegmentedProgressView) findViewById(R.id.spvLoader);
        spvLoader.startAnimation();
    }

}
