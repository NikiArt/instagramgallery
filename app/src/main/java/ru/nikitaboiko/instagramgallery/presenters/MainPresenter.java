package ru.nikitaboiko.instagramgallery.presenters;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import javax.inject.Inject;

import ru.nikitaboiko.instagramgallery.MainView;
import ru.nikitaboiko.instagramgallery.adapters.GiphyAdapter;
import ru.nikitaboiko.instagramgallery.model.DataGetter;
import ru.nikitaboiko.instagramgallery.model.GiphyRepo;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    @Inject
    DataGetter dataGetter;

    @Inject
    GiphyRepo giphyRepo;

    public void getGiphiesFromApi(String searchValue, GiphyAdapter giphyAdapter) {
        dataGetter.getGiphies(searchValue, giphyAdapter);
    }
}
