package com.example.sportmagazine.repository.local.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.sportmagazine.Noticia;

import java.util.List;

@Dao
public interface NoticiaDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insert(Noticia noticia);
    @Query("DELETE FROM noticia")
    void deleteleAll();
    @Query("SELECT * FROM noticia where read=:leido ORDER BY id ASC")
    LiveData<List<Noticia>> getAll(boolean leido);
    @Update(onConflict = OnConflictStrategy.IGNORE)
    void updateEntry(Noticia task);
    @Query("SELECT * FROM noticia WHERE id=:id")
    LiveData<Noticia> getById(long id);
}

