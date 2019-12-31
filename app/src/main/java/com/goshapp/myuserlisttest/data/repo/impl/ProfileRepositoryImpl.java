package com.goshapp.myuserlisttest.data.repo.impl;

import com.goshapp.myuserlisttest.api.UserApi;

import com.goshapp.myuserlisttest.data.db.dao.ProfileDao;
import com.goshapp.myuserlisttest.data.pojo.RandomUser;
import com.goshapp.myuserlisttest.data.repo.ProfileRepository;

import io.reactivex.Completable;
import io.reactivex.Single;

public class ProfileRepositoryImpl implements ProfileRepository {

    private final UserApi userApi;
    private final ProfileDao profileDao;

    public ProfileRepositoryImpl(UserApi userApi, ProfileDao profileDao) {
        this.userApi = userApi;
        this.profileDao = profileDao;
    }

    @Override
    public Completable profile(RandomUser randomUser) {
        return Completable.fromAction(() -> profileDao.insert(randomUser));
    }

    private Single<RandomUser> localProfile() {
        return profileDao.getProfile()
                .firstOrError();
    }
}
