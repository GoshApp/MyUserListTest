package com.goshapp.myuserlisttest.data.repo;


import com.goshapp.myuserlisttest.data.pojo.RandomUser;

import io.reactivex.Completable;

public interface ProfileRepository {
    Completable profile(RandomUser randomUser);
}
