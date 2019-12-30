package com.goshapp.myuserlisttest;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.goshapp.myuserlisttest.di.AppComponent;
import com.goshapp.myuserlisttest.di.DaggerAppComponent;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

/**
 * Created by rikmen00@gmail.com on 30.12.2019.
 */

public class UserListApp extends Application implements HasActivityInjector{

    @Inject
    DispatchingAndroidInjector<Activity> androidInjector;


    AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .application(this)
                .build();

        appComponent.inject(this);



    }

    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return androidInjector;
    }

    public static AppComponent getAppComponent(Context context) {
        return ((UserListApp) context.getApplicationContext()).appComponent;
    }
}
