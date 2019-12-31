package com.goshapp.myuserlisttest.di.modules;

import com.goshapp.myuserlisttest.api.UserApi;
import com.goshapp.myuserlisttest.data.db.dao.ProfileDao;
import com.goshapp.myuserlisttest.data.repo.ProfileRepository;
import com.goshapp.myuserlisttest.data.repo.impl.ProfileRepositoryImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = MapperModule.class)
public class RepositoryModule {

    @Provides
    @Singleton
    ProfileRepository providesProfileRepository(UserApi api,
                                                ProfileDao profileDao) {
        return new ProfileRepositoryImpl(api, profileDao);
    }
}
