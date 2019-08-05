package ru.nikitaboiko.instagramgallery.di;

import dagger.Module;
import dagger.Provides;
import ru.nikitaboiko.instagramgallery.App;

@Module
public class AppModule {
    private App app;

    public AppModule(App app) {
        this.app = app;
    }

    @Provides
    public App app() {
        return app;
    }
}
