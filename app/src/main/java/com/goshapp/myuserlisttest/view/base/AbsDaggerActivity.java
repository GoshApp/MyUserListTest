package com.goshapp.myuserlisttest.view.base;

/**
 * Represents activity that injects presenter factory
 *
 * @param <P>
 */

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import com.goshapp.myuserlisttest.util.AnnotationUtil;
import com.goshapp.myuserlisttest.util.mvp.BasePresenter;
import com.goshapp.myuserlisttest.util.mvp.PresenterFactory;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public abstract class AbsDaggerActivity<P extends AbsPresenter> extends AppCompatActivity {

    @Inject
    public PresenterFactory factory;

    private P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inject();
    }

    @NonNull
    public P getPresenter() {
        if (presenter == null)
            throw new IllegalStateException("Presenter not found");
        return presenter;
    }

    @Nullable
    public P getPresenterForce() {
        return presenter;
    }

    private void inject() {
        if (AnnotationUtil.hasPresenter(this)) {
            AndroidInjection.inject(this);
            setPresenter();
        }
    }

    private void setPresenter() {
        Class<? extends BasePresenter> presenterClass = AnnotationUtil.findPresenterClass(this);
        if (presenterClass == null)
            throw new IllegalStateException("Presenter class not found");
        presenter = factory.provide(presenterClass);
    }
}
