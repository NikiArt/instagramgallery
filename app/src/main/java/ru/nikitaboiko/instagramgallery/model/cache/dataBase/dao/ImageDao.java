package ru.nikitaboiko.instagramgallery.model.cache.dataBase.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import ru.nikitaboiko.instagramgallery.model.cache.dataBase.dbObjects.GiphyImage;

@Dao
public interface ImageDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(GiphyImage giphyImage);

    @Update
    void update(GiphyImage giphyImage);

    @Delete
    void delete(GiphyImage giphyImage);

    @Query("SELECT * FROM giphyimage WHERE url IN (:imageUrls)")
    List<GiphyImage> getImages(List<String> imageUrls);
}
