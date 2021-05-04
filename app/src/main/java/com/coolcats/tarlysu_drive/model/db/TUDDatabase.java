package com.coolcats.tarlysu_drive.model.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.coolcats.tarlysu_drive.model.data.Car;

@Database(version = 1, entities = {Car.class})
public abstract class TUDDatabase extends RoomDatabase {

    private static TUDDatabase database;
    public abstract CarDAO getDAO();

    public static TUDDatabase getDatabase(Context context) {
        if(database == null){
            database = Room.databaseBuilder(
                    context,
                    TUDDatabase.class,
                    "tud.db"
            ).build();
        }
        return database;
    }
}
