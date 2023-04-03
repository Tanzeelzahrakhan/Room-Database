package com.example.roomdatabase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {


    @Insert
    void insertAll(User... users);

    @Query("SELECT EXISTS(SELECT * FROM User WHERE uid = :userId)")
    Boolean is_exists(int userId);


 






}