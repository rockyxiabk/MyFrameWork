package com.rocky.myframework;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by y7un on 2016/5/3.
 */
public class APPApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
