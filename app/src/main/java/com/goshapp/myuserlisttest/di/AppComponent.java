package com.goshapp.myuserlisttest.di;

import android.app.Application;

import com.goshapp.myuserlisttest.UserListApp;
import com.goshapp.myuserlisttest.di.modules.ActivityModule;
import com.goshapp.myuserlisttest.di.modules.AppModule;
import com.goshapp.myuserlisttest.di.modules.PresenterModule;
import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Singleton
@Component(modules = {
        AndroidInjectionModule.class,
        AppModule.class,
        PresenterModule.class,
        ActivityModule.class
})
public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }

    void inject(UserListApp application);

}
