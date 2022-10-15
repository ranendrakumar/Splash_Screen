package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.splashscreen.databinding.ActivitySplashScreenBinding;

public class SplashScreen extends AppCompatActivity {

    private ActivitySplashScreenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashScreenBinding.inflate(getLayoutInflater());
        //full screen
        View view = getWindow().getDecorView();
        view.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        |View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
        |View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                |View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                |View.SYSTEM_UI_FLAG_FULLSCREEN
                |View.SYSTEM_UI_FLAG_IMMERSIVE);

        //ANDROID DEFAULT
        setContentView(binding.getRoot());

        Animation logoAnimation = AnimationUtils.loadAnimation(SplashScreen.this,R.anim.zoom_animation);
        Animation appnameAnimation = AnimationUtils.loadAnimation(SplashScreen.this,R.anim.zoom_animation);


        binding.imageView.setVisibility(View.VISIBLE);
        binding.imageView.startAnimation(logoAnimation);

        logoAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {}
            @Override
            public void onAnimationEnd(Animation animation) {
              binding.appname.setVisibility(View.VISIBLE);
              binding.appname.startAnimation(appnameAnimation);
            }
            @Override
            public void onAnimationRepeat(Animation animation) {}
        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                //checkUser();
                startActivity(new Intent(SplashScreen.this, MainActivity.class));
                finish();

            }
        },1000);


        //checkUser();


    }
}