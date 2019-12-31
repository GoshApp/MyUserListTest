package com.goshapp.myuserlisttest.data.converter;


import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.goshapp.myuserlisttest.data.pojo.Info;
import com.goshapp.myuserlisttest.data.pojo.Result;

import java.lang.reflect.Type;
import java.util.List;

public class InfoListTypeConverter {

    @TypeConverter
    public String fromResultList(List<Info> res) {
        if (res == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<Info>>() {}.getType();
        String json = gson.toJson(res, type);
        return json;
    }

    @TypeConverter
    public List<Info> toResultsList(String resString) {
        if (resString == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<Info>>() {}.getType();
        return gson.fromJson(resString, type);
    }
}
