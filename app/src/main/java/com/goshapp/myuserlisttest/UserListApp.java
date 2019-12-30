package com.goshapp.myuserlisttest;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import androidx.fragment.app.Fragment;

import com.goshapp.myuserlisttest.di.AppComponent;

import java.util.Set;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import dagger.android.support.HasSupportFragmentInjector;

/**
 * Created by rikmen00@gmail.com on 30.12.2019.
 */

public class UserListApp extends Application implements HasActivityInjector, HasSupportFragmentInjector {

    @Inject
    DispatchingAndroidInjector<Activity> androidInjector;
    @Inject
    DispatchingAndroidInjector<Fragment> androidFragmentInjector;

    UserListApp appComponent;

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

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return androidFragmentInjector;
    }

    public static UserListApp getAppComponent(Context context) {
        return ((UserListApp) context.getApplicationContext()).appComponent;
    }
}
