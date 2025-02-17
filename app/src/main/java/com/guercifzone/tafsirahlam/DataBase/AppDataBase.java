package com.guercifzone.tafsirahlam.DataBase;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {DataItem.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {
    public abstract DataItemDao dataItemDao();
}
