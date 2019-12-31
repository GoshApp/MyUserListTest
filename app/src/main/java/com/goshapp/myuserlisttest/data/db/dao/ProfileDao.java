package com.goshapp.myuserlisttest.data.db.dao;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;


import com.goshapp.myuserlisttest.data.pojo.RandomUser;

import io.reactivex.Flowable;

@Dao
public interface ProfileDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(RandomUser randomUser);

    @Query("SELECT * FROM randomUser LIMIT 1")
    Flowable<RandomUser> getProfile();

    @Query("DELETE FROM randomUser")
    void clearTable();
}
