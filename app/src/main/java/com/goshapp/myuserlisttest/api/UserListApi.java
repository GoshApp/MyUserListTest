package com.goshapp.myuserlisttest.api;

import com.goshapp.myuserlisttest.api.response.RandomUser;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by rikmen00@gmail.com on 30.12.2019.
 */

public interface UserListApi {
    @GET("api")
    Observable <RandomUser> getRandUser();
}