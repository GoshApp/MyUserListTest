package com.goshapp.myuserlisttest.util.mvp;

public interface PresenterFactory {

    <P extends BasePresenter> P provide(Class <? extends BasePresenter> presenterClass);


}
