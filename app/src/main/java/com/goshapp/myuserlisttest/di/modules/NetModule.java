package com.goshapp.myuserlisttest.di.modules;

import com.google.gson.Gson;
import com.goshapp.myuserlisttest.BuildConfig;
import com.goshapp.myuserlisttest.api.UserListApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetModule {

    @Singleton
    @Provides
    UserListApi provideRetrofit(OkHttpClient client, Gson gson) {
        return new Retrofit.Builder()
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BuildConfig.BASE_URL)
                .build()
                .create(UserListApi.class);
    }
}
