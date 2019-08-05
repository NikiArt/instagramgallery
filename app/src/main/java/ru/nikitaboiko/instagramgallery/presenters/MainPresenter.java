package ru.nikitaboiko.instagramgallery.presenters;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import javax.inject.Inject;

import ru.nikitaboiko.instagramgallery.MainView;
import ru.nikitaboiko.instagramgallery.adapters.GiphyAdapter;
import ru.nikitaboiko.instagramgallery.model.DataGetter;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    @Inject
    DataGetter dataGetter;

    public void getGiphiesFromApi(String searchValue, GiphyAdapter giphyAdapter) {
        dataGetter.getGiphies(searchValue, giphyAdapter);
    }
}
