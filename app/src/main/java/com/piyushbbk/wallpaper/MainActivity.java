package com.piyushbbk.wallpaper;

import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements
        View.OnClickListener {
    Button btnChangeWallpaper;
    boolean running;
    int[] imagesArray=new int[]
            {
                    R.drawable.hulk,
                    R.drawable.iron,
                    R.drawable.spiderman,
                    R.drawable.wanda,
                    R.drawable.widow,
            };
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnChangeWallpaper=(Button)
                findViewById(R.id.btn_start_change_wallpaper);
        btnChangeWallpaper.setOnClickListener(this);
    }
    @Override
    public void onClick(View view)
    {
        if(!running)
        {
            new Timer().schedule (new MyTimer(),0,3000);
            running=true;
        }
    }
    class MyTimer extends TimerTask {
        public void run() {
            try {
                WallpaperManager wallpaperManager =
                        WallpaperManager.getInstance(getBaseContext());
                Random random=new Random();

                wallpaperManager.setBitmap(BitmapFactory.decodeResource(getResources(),imagesArray[random.nextInt(5)]));
                i++;
            } catch (Exception e)
            { }
        }
    } }
