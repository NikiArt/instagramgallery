package ru.nikitaboiko.instagramgallery.model.cache;

import java.util.List;
import java.util.UUID;

import io.reactivex.Completable;
import io.reactivex.Maybe;
import ru.nikitaboiko.instagramgallery.model.cache.dataBase.DataBase;
import ru.nikitaboiko.instagramgallery.model.cache.dataBase.dbObjects.GiphyImage;
import ru.nikitaboiko.instagramgallery.model.cache.dataBase.dbObjects.GiphyTag;

public class RoomCache {

    private DataBase dataBase;

    public RoomCache(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    public Maybe<List<GiphyImage>> getImages(String tag) {
        return Maybe.fromCallable(() -> {
            List<String> giphyImages = dataBase.getTagDao().getImagesByTag(tag);
            return dataBase.getImageDao().getImages(giphyImages);
        });
    }

    public Completable addTag(String giphyImage, String tag) {
        return Completable.fromAction(() -> {
            GiphyTag existTag = dataBase.getTagDao().getExistTag(tag, giphyImage);
            if (existTag == null) {
                GiphyTag newTag = new GiphyTag();
                newTag.setId(UUID.randomUUID().toString());
                newTag.setImageUrl(giphyImage);
                newTag.setTag(tag);
                dataBase.getTagDao().insert(newTag);
            }

        });


    }

    public Completable addImage(String giphyImage) {
        return Completable.fromAction(() -> {
            GiphyImage image = new GiphyImage();
            image.setUrl(giphyImage);
            dataBase.getImageDao().insert(image);
        });

    }
}
