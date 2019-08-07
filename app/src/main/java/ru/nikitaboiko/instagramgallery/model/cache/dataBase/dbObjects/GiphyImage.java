package ru.nikitaboiko.instagramgallery.model.cache.dataBase.dbObjects;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity
public class GiphyImage {

    @PrimaryKey
    private String url;

    private Boolean favourite;

    @Ignore
    private List<GiphyTag> tags;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Boolean getFavourite() {
        return favourite;
    }

    public void setFavourite(Boolean favourite) {
        this.favourite = favourite;
    }

    public List<GiphyTag> getTags() {
        return tags;
    }

    public void setTags(List<GiphyTag> tags) {
        this.tags = tags;
    }
}
