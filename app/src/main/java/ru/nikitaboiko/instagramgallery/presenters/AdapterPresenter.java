package ru.nikitaboiko.instagramgallery.presenters;


import javax.inject.Inject;

import ru.nikitaboiko.instagramgallery.model.DataGetter;

public class AdapterPresenter {
    @Inject
    DataGetter dataGetter;

    public String getUrl(int position) {
        return dataGetter.getImageUrls().get(position);
    }

    public int getSize() {
        return dataGetter.getImageUrls().size();
    }
}
