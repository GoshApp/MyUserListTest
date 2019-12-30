package com.goshapp.myuserlisttest.di.modules;

import com.goshapp.myuserlisttest.view.ui.main.MainScreenActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract MainScreenActivity contributeMainScreenActivity();

}
