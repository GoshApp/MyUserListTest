package com.goshapp.myuserlisttest.data.converter;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.goshapp.myuserlisttest.data.pojo.Location;

import java.lang.reflect.Type;
import java.util.List;

public class LocationListTypeConverter {

    @TypeConverter
    public String fromResultList(List<Location> res) {
        if (res == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<Location>>() {}.getType();
        String json = gson.toJson(res, type);
        return json;
    }

    @TypeConverter
    public List<Location> toResultsList(String resString) {
        if (resString == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<Location>>() {}.getType();
        return gson.fromJson(resString, type);
    }
}