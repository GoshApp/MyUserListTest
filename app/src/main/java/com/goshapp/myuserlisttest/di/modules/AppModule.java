package com.goshapp.myuserlisttest.di.modules;

import android.app.Application;
import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.goshapp.myuserlisttest.data.provider.ResourceProvider;
import com.goshapp.myuserlisttest.data.provider.ResourceProviderImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = {
        NetModule.class,
})
public class AppModule {

    @Singleton
    @Provides
    Gson provideGson() {
        return new GsonBuilder().create();
    }

    @Provides
    public Context provideContext(Application application) {
        return application.getApplicationContext();
    }

    @Provides
    public ResourceProvider provideStringProvider(Context context) {
        return new ResourceProviderImpl(context);
    }

}
