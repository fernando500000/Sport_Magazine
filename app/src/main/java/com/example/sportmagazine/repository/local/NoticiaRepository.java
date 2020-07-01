package com.example.sportmagazine.repository.local;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.sportmagazine.Noticia;
import com.example.sportmagazine.repository.local.db.NoticiaDb;

import java.util.List;

public class NoticiaRepository {
    private NoticiaDb db;

    public NoticiaRepository(Application application) {
        db = NoticiaDb.getDatabase(application);
    }

    public void insert(final Noticia noticia) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                db.noticiaDao().insert(noticia);
            }
        });
        thread.start();
    }

    public void deleteAll() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                db.noticiaDao().deleteleAll();
            }
        });
        thread.start();
    }

    public LiveData<List<Noticia>> getAll() {
        return db.noticiaDao().getAll(false);
    }


    public void updateEntry(final Noticia task) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                db.noticiaDao().updateEntry(task);
            }
        });
        thread.start();
    }
    public LiveData<Noticia> getById(long id) {
        return db.noticiaDao().getById(id);
    }
}
