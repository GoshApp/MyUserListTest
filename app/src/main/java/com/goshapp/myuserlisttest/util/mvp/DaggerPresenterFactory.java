package com.goshapp.myuserlisttest.util.mvp;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

import timber.log.Timber;

@Singleton
public class DaggerPresenterFactory implements PresenterFactory {

    private final Map <Class <? extends BasePresenter>, Provider<BasePresenter>> creators;

    @Inject
    public DaggerPresenterFactory(Map <Class <? extends BasePresenter>, Provider<BasePresenter>> creators) {
        this.creators = creators;
    }

    private <P extends BasePresenter> P create(Class <? extends BasePresenter> presenterClass) {
        Provider<? extends BasePresenter> creator = creators.get(presenterClass);
        if (creator == null) {
            for (Map.Entry<Class <? extends BasePresenter>, Provider<BasePresenter>> entry : creators.entrySet()) {
                if (presenterClass.isAssignableFrom(entry.getKey())) {
                    creator = entry.getValue();
                    break;
                }
            }
        }
        if (creator == null) {
            throw new IllegalArgumentException("Unknown presenter class " + presenterClass);
        }
        try {
            return (P) creator.get();
        } catch (Exception e) {
            Timber.e(e);
            throw new RuntimeException();
        }
    }

    @Override
    public <P extends BasePresenter> P provide(Class <? extends BasePresenter> presenterClass) {
        return create(presenterClass);
    }
}
