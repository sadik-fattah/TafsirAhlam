package com.guercifzone.tafsirahlam.DataBase;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;


@Dao
public interface DataItemDao {
    @Insert
    void insert(DataItem dataItem);

    @Query("SELECT * FROM data_items")
    List<DataItem> getAllDataItems();
}

