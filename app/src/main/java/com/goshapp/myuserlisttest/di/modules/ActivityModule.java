package com.goshapp.myuserlisttest.di.modules;

import com.goshapp.myuserlisttest.view.ui.MainScreenActivity;

import dagger.android.ContributesAndroidInjector;

public abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract MainScreenActivity contributeMainActivity();

}
