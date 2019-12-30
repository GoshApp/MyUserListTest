package com.goshapp.myuserlisttest.util.mvp;

public interface BasePresenter<V extends BaseView> {

    void bindView(V view);

    void unbindView();

    void onCreate(V view);

    void onVisible(V view);

    void onCleanup();

    boolean isBinded();

    /**
     * Subscribe for single onBindCall
     *
     * @param observable
     */
    void subscribeOnBind(BindObservable observable);

    void unsubscribeOnBind(BindObservable bindObservable);

    interface BindObservable {
        void onBinded(BindObservable it);
    }
}
