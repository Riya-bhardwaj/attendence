package com.example.home.attendance_app;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 3000;
    private ImageView welcome;
    private ImageView cccLogo;
    private TextView cccText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        welcome=(ImageView)findViewById(R.id.welcome);
        cccLogo=(ImageView)findViewById(R.id.cccLogo);
        cccText=(TextView)findViewById(R.id.cccText);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeScreen = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(homeScreen);
                finish();
            }
        }, SPLASH_TIME_OUT);
        Animation myanim = AnimationUtils.loadAnimation(this,R.anim.mysplashanimation);
        welcome.startAnimation(myanim);
        Animation myanim2 = AnimationUtils.loadAnimation(this,R.anim.ccc_logo);
        cccLogo.startAnimation(myanim2);
        Animation myanim3 = AnimationUtils.loadAnimation(this,R.anim.ccc_logo);
        cccText.startAnimation(myanim3);


    }
}
