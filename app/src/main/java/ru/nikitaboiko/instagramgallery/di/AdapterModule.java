package ru.nikitaboiko.instagramgallery.di;

import dagger.Module;
import dagger.Provides;
import ru.nikitaboiko.instagramgallery.adapters.GiphyAdapter;
import ru.nikitaboiko.instagramgallery.presenters.AdapterPresenter;

@Module
public class AdapterModule {

    @Provides
    public AdapterPresenter adapterPresenter() {
        return new AdapterPresenter();
    }

    @Provides
    public GiphyAdapter giphyAdapter(AdapterPresenter adapterPresenter) {
        return new GiphyAdapter(adapterPresenter);
    }
}
