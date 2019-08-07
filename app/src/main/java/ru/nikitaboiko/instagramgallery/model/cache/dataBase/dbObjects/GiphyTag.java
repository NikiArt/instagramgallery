package ru.nikitaboiko.instagramgallery.model.cache.dataBase.dbObjects;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class GiphyTag {

    @PrimaryKey
    private String id;

    private String imageUrl;

    private String tag;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
