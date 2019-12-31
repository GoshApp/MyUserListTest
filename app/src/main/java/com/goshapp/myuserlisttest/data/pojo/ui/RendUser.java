package com.goshapp.myuserlisttest.data.pojo.ui;

import androidx.room.TypeConverters;
import com.goshapp.myuserlisttest.data.converter.InfoListTypeConverter;
import com.goshapp.myuserlisttest.data.converter.ResultListTypeConverter;
import com.goshapp.myuserlisttest.data.pojo.Info;
import com.goshapp.myuserlisttest.data.pojo.Result;

import java.util.List;

public class RendUser {

    public int id;
    @TypeConverters(ResultListTypeConverter.class)
    public List<Result> results;
    @TypeConverters(InfoListTypeConverter.class)
    private List<Info> info;
    public List<Result> getResults() {
        return results;
    }


    public int getId() {
        return id;
    }

    public RendUser setId(int id) {
        this.id = id;
        return this;

    }

    public RendUser setResults(List<Result> results) {
        this.results = results;
        return this;
    }

    public List<Info> getInfo() {
        return info;
    }

    public RendUser setInfo(List<Info> info) {
        this.info = info;
        return this;
    }
}