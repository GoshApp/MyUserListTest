package com.goshapp.myuserlisttest.view.ui.main;

import com.goshapp.myuserlisttest.util.mvp.BaseView;
import com.goshapp.myuserlisttest.view.base.AbsPresenter;

import javax.inject.Inject;

/**
 * Created by rikmen00@gmail.com on 30.12.2019.
 */

public class MainScreenPresenter extends AbsPresenter <MainScreenPresenter.View> {

    @Inject
    public MainScreenPresenter(){}

    interface View extends BaseView {

    }
}
