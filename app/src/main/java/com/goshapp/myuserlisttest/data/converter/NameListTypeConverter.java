package com.goshapp.myuserlisttest.data.converter;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.goshapp.myuserlisttest.data.pojo.Name;

import java.lang.reflect.Type;
import java.util.List;

public class NameListTypeConverter {
    @TypeConverter
    public String fromResultList(List<Name> res) {
        if (res == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<Name>>() {}.getType();
        String json = gson.toJson(res, type);
        return json;
    }

    @TypeConverter
    public List<Name> toResultsList(String resString) {
        if (resString == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<Name>>() {}.getType();
        return gson.fromJson(resString, type);
    }
}
