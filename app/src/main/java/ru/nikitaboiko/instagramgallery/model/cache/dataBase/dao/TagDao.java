package ru.nikitaboiko.instagramgallery.model.cache.dataBase.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import ru.nikitaboiko.instagramgallery.model.cache.dataBase.dbObjects.GiphyTag;

@Dao
public interface TagDao {
    @Insert
    void insert(GiphyTag giphyTag);

    @Delete
    void delete(GiphyTag giphyTag);

    @Query("SELECT * FROM giphytag WHERE tag=:tag")
    List<GiphyTag> getTags(String tag);

    @Query("SELECT * FROM giphytag WHERE tag=:tag AND imageUrl=:url LIMIT 1")
    GiphyTag getExistTag(String tag, String url);

    @Query("SELECT imageUrl FROM giphytag WHERE tag=:tag")
    List<String> getImagesByTag(String tag);
}
