package ru.nikitaboiko.instagramgallery.model.cache.dataBase;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import ru.nikitaboiko.instagramgallery.model.cache.dataBase.dao.ImageDao;
import ru.nikitaboiko.instagramgallery.model.cache.dataBase.dao.TagDao;
import ru.nikitaboiko.instagramgallery.model.cache.dataBase.dbObjects.GiphyImage;
import ru.nikitaboiko.instagramgallery.model.cache.dataBase.dbObjects.GiphyTag;

@Database(entities = {GiphyImage.class, GiphyTag.class}, version = 1)
public abstract class DataBase extends RoomDatabase {
    public abstract ImageDao getImageDao();

    public abstract TagDao getTagDao();
}
