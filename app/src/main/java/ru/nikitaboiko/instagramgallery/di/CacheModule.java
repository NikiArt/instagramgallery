package ru.nikitaboiko.instagramgallery.di;

import androidx.room.Room;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.nikitaboiko.instagramgallery.App;
import ru.nikitaboiko.instagramgallery.model.cache.RoomCache;
import ru.nikitaboiko.instagramgallery.model.cache.dataBase.DataBase;

@Module
public class CacheModule {

    @Singleton
    @Provides
    public DataBase getDataBase(App app) {
        return Room.databaseBuilder(app, DataBase.class, "giphyDatabase").build();
    }

    @Singleton
    @Provides
    public RoomCache roomCache(DataBase dataBase) {

        return new RoomCache(dataBase);
    }

}
