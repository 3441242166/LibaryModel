package com.example.administrator.libarymodel;

import android.app.Application;

import com.example.net.interceptors.DebugInterceptor;
import com.example.projectcore.Config;

public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Config.init(this)
                //.withApiHost("")

                .withApiHost("http://toppest.ink:8086/")
                .configure();
    }
}
