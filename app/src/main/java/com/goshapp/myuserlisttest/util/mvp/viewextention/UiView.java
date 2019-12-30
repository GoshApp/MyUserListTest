package com.goshapp.myuserlisttest.util.mvp.viewextention;


public interface UiView {

    int DEFAULT_DELAY = 0;

    void enableTouch();

    void disableTouch();

    void post(Runnable runnable, long delay);

    default void post(Runnable runnable) {
        post(runnable, DEFAULT_DELAY);
    }

}
