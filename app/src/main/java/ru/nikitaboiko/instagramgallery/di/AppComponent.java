package ru.nikitaboiko.instagramgallery.di;

import javax.inject.Singleton;

import dagger.Component;
import ru.nikitaboiko.instagramgallery.MainActivity;
import ru.nikitaboiko.instagramgallery.presenters.AdapterPresenter;
import ru.nikitaboiko.instagramgallery.presenters.MainPresenter;

@Singleton
@Component(modules = {
        ApiModule.class,
        AppModule.class,
        AdapterModule.class
})

public interface AppComponent {
    void inject(MainPresenter mainPresenter);

    void inject(AdapterPresenter adapterPresenter);

    void inject(MainActivity mainActivity);
}
