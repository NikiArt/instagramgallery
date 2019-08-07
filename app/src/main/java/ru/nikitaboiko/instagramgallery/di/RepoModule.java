package ru.nikitaboiko.instagramgallery.di;


import dagger.Module;
import dagger.Provides;
import ru.nikitaboiko.instagramgallery.model.DataGetter;
import ru.nikitaboiko.instagramgallery.model.GiphyRepo;
import ru.nikitaboiko.instagramgallery.model.cache.RoomCache;

@Module(includes = {CacheModule.class, ApiModule.class})
public class RepoModule {

    @Provides
    public GiphyRepo getRepo(DataGetter dataGetter, RoomCache roomCache) {
        return new GiphyRepo(dataGetter, roomCache);
    }
}
