package com.goshapp.myuserlisttest.di.modules;

import com.goshapp.myuserlisttest.di.PresenterKey;
import com.goshapp.myuserlisttest.util.mvp.BasePresenter;
import com.goshapp.myuserlisttest.util.mvp.DaggerPresenterFactory;
import com.goshapp.myuserlisttest.util.mvp.PresenterFactory;
import com.goshapp.myuserlisttest.view.ui.main.MainScreenPresenter;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class PresenterModule {

    @Binds
    @IntoMap
    @PresenterKey(MainScreenPresenter.class)
    abstract BasePresenter bindMainScreenPresenter(MainScreenPresenter mainScreenPresenter);

    @Binds
    abstract PresenterFactory bindPresenterFactory(DaggerPresenterFactory daggerPresenterFactory);


}
