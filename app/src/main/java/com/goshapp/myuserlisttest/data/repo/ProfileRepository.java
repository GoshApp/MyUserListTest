package com.goshapp.myuserlisttest.data.repo;

import com.goshapp.myuserlisttest.api.response.RandomUser;

import io.reactivex.Completable;

public interface ProfileRepository {
    Completable profile(RandomUser randomUser);
}
