package ru.nikitaboiko.instagramgallery.model.parsingJson;

import java.util.ArrayList;
import java.util.List;

public class ResponseGiphy {
    private List<DataGiphy> data = new ArrayList<>();

    public List<DataGiphy> getData() {
        return this.data;
    }

    public void setData(List<DataGiphy> data) {
        this.data = data;
    }
}
