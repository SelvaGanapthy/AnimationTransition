package com.micromen.transition;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.MainThread;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= 21) {
            TransitionInflater inflater = TransitionInflater.from(this);
            Transition transition = inflater.inflateTransition(R.transition.shared_transition);
            getWindow().setExitTransition(transition);
            Slide slide = new Slide();
            slide.setDuration(2000);
            getWindow().setEnterTransition(slide);
        }
        setContentView(R.layout.activity_main);
    }

    public void fun1(View v) {
        ActivityOptionsCompat compat = ActivityOptionsCompat.makeSceneTransitionAnimation(this, null);
        startActivity(new Intent(MainActivity.this, Main2Activity.class), compat.toBundle());
    }
}
