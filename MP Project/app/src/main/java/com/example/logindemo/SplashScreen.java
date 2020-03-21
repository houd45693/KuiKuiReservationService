package com.example.logindemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

public class SplashScreen extends AppCompatActivity {

//    private int SLEEP_TIMER = 4;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3000);


//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
//
//        setContentView(R.layout.activity_splash_screen);
//        getSupportActionBar().hide();
//        LogoLauncher logoLauncher = new LogoLauncher();
//        logoLauncher.start();
    }

//    private class LogoLauncher extends Thread{
//        public void run(){
//            try{
//                sleep(1000 * SLEEP_TIMER);
//            }catch(InterruptedException e){
//                e.printStackTrace();
//            }
//
//            Intent intent = new Intent(SplashScreen.this, MainActivity.class);
//            startActivity(intent);
//            SplashScreen.this.finish();
//        }
//    }
}
