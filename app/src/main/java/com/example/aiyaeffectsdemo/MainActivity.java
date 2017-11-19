package com.example.aiyaeffectsdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.aiyaapp.camera.sdk.AiyaEffects;
import com.aiyaapp.camera.sdk.base.ActionObserver;
import com.aiyaapp.camera.sdk.base.Event;
import com.aiyaapp.camera.sdk.base.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();

    }



    private void init() {
        final ActionObserver observer = new ActionObserver() {
            @Override
            public void onAction(Event event) {
                if(event.eventType == Event.RESOURCE_FAILED){
                    Log.e("resource failed");
                }else if(event.eventType == Event.RESOURCE_READY){
                    Log.e("resource ready");
                }else if(event.eventType == Event.PROCESS_PLAY){
                    Log.e("resource play");
                }else if(event.eventType == Event.INIT_FAILED){
                    Log.e("init faied");
                    AiyaEffects.getInstance().unRegisterObserver(this);
                }else if(event.eventType == Event.INIT_SUCCESS){
                    Log.e("init success");
                    setContentView(R.layout.activity_main);
                    AiyaEffects.getInstance().unRegisterObserver(this);
                }
            }
        };

        AiyaEffects.getInstance().registerObserver(observer);
        AiyaEffects.getInstance().init(getApplicationContext(),Constant.APPKEY);
    }
}
