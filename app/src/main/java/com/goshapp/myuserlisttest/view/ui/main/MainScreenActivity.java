package com.goshapp.myuserlisttest.view.ui.main;

import com.goshapp.myuserlisttest.util.mvp.annotation.RequiresPresenter;
import com.goshapp.myuserlisttest.view.base.AbsToolbarActivity;

/**
 * Created by rikmen00@gmail.com on 30.12.2019.
 */

@RequiresPresenter(MainScreenPresenter.class)

public class MainScreenActivity extends AbsToolbarActivity<MainScreenPresenter> implements MainScreenPresenter.View {


    @Override
    public void showError(int title, String string, Runnable runnable) {

    }

    @Override
    public void showTimeOutError() {

    }

    @Override
    public void showSessionTimeout() {

    }

    @Override
    public void showToast(int id) {

    }

    @Override
    public void showToast(String message) {

    }

    @Override
    public void enableTouch() {

    }

    @Override
    public void disableTouch() {

    }

    @Override
    public void post(Runnable runnable, long delay) {

    }
}
