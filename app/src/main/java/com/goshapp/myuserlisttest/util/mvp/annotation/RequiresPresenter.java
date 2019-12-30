package com.goshapp.myuserlisttest.util.mvp.annotation;


import com.goshapp.myuserlisttest.util.mvp.BasePresenter;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface RequiresPresenter {
    Class<? extends BasePresenter> value();
}
