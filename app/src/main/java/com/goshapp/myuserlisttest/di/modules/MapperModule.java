package com.goshapp.myuserlisttest.di.modules;

import com.goshapp.myuserlisttest.data.pojo.RandomUser;
import com.goshapp.myuserlisttest.data.pojo.ui.RendUser;
import com.goshapp.myuserlisttest.util.mvp.Mapper;

import dagger.Module;
import dagger.Provides;

@Module
public class MapperModule {

    @Provides
    Mapper<RandomUser, RendUser> provideProfileUserProfileMapper() {
        return user -> new RendUser()
                .setId(user.getId())
                .setResults(user.getResults())
                .setInfo(user.getInfo()
                );
    }
}
