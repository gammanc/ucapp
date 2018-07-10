package com.team.ucapp.data.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface EventDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertEvents(ArrayList<Event> events);

    @Query("SELECT * FROM events ORDER BY date DESC")
    LiveData<List<Event>> getAll();

    @Query("DELETE FROM events")
    void deleteAll();
}
