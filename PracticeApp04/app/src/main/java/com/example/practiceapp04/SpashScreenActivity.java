package com.example.practiceapp04;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SpashScreenActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spalsh_screen);

        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                Thread.sleep(3000);

                    startActivity( new Intent(SpashScreenActivity.this,DummyActivity.class));
                    finish();
                }
                catch (Exception x){


                }
            }
        });
        th.start();

    }
}
