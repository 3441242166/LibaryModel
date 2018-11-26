package com.example.administrator.base;

import android.app.Application;

import com.example.config.Config;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Config.init(this)
                .withApiHost("http://toppest.ink:8086/")
                .configure();

        Logger.addLogAdapter(new AndroidLogAdapter());

    }
}
