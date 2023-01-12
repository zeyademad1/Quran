package com.example.anamoslim.data.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.anamoslim.data.pojo.Aya;

@Database(entities = {Aya.class}, version = 1 , exportSchema = false)
public abstract class QuranDataBase extends RoomDatabase {
    private static QuranDataBase instance = null;
    public abstract QuranDao quranDao();
    public static QuranDataBase getInstance(final Context context) {
        if (instance == null) {
            synchronized (QuranDataBase.class) {
                if (instance == null) {
                    String DATABASE_NAME = "quran.db";
                    instance = Room.databaseBuilder(context.getApplicationContext(), QuranDataBase.class, DATABASE_NAME)
                            .createFromAsset("quran/databases/quran.db")
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return instance;
    }




}
