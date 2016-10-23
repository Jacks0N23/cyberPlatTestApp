package com.jassdev.jackson.cyberplattestapp;

import android.app.Application;
import android.content.Context;

import com.jassdev.jackson.cyberplattestapp.di.AppComponent;
import com.jassdev.jackson.cyberplattestapp.di.DaggerAppComponent;
import com.jassdev.jackson.cyberplattestapp.di.FeedItemsModule;

/**
 * Created by Jackson on 23/10/2016.
 */

public class DaggerTestApp extends Application {
    AppComponent appComponent;

    public static AppComponent component(Context context) {
        return ((DaggerTestApp) context.getApplicationContext()).appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .feedItemsModule(new FeedItemsModule())
                .build();
    }

}
