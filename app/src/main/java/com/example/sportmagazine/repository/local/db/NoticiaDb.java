package com.example.sportmagazine.repository.local.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.sportmagazine.Noticia;
import com.example.sportmagazine.repository.local.dao.NoticiaDao;

@Database(entities = Noticia.class, version = 2)
public abstract class NoticiaDb extends RoomDatabase {
    public abstract NoticiaDao noticiaDao();

    private static volatile NoticiaDb INSTANCE;


    static public NoticiaDb getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (NoticiaDb.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            NoticiaDb.class, "noticia_database2")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
