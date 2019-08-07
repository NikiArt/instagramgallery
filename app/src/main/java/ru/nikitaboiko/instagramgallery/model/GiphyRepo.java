package ru.nikitaboiko.instagramgallery.model;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import ru.nikitaboiko.instagramgallery.model.cache.RoomCache;
import ru.nikitaboiko.instagramgallery.model.cache.dataBase.dbObjects.GiphyImage;

public class GiphyRepo {
    private DataGetter dataGetter;
    private RoomCache roomCache;

    public GiphyRepo(DataGetter dataGetter, RoomCache roomCache) {
        this.dataGetter = dataGetter;
        this.roomCache = roomCache;
    }

    public void getImageArray(String request) {
        List<String> giphiesArray = dataGetter.getImgArray(request);
        for (int i = 0; i < giphiesArray.size(); i++) {
            addToDbAndGetValue(giphiesArray.get(i), request)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(imageList -> {

                    });

        }

    }

    private Single<GiphyImage> addToDbAndGetValue(String url, String tag) {
        return Single.fromCallable(() -> {
            roomCache.addTag(url, tag)
                    .subscribeOn(Schedulers.io())
                    .subscribe();
            roomCache.addImage(url)
                    .subscribeOn(Schedulers.io())
                    .subscribe();
            roomCache.getImages(tag)
                    .subscribeOn(Schedulers.newThread())
                    .subscribe();
        });

    }
}
