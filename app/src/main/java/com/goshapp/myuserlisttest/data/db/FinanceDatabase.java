package com.goshapp.myuserlisttest.data.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.goshapp.myuserlisttest.data.db.dao.ProfileDao;
import com.goshapp.myuserlisttest.data.pojo.RandomUser;

@Database(entities = {RandomUser.class}, version = 1, exportSchema = false)

public abstract class FinanceDatabase extends RoomDatabase {

    public abstract ProfileDao profileDao();
}
