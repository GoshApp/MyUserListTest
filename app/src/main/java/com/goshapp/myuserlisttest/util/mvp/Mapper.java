package com.goshapp.myuserlisttest.util.mvp;

public interface Mapper<From, To> {
    To map(From from);
}
