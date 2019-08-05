package ru.nikitaboiko.instagramgallery.model.parsingJson;

public class ImagesGiphy {
    private OriginalGiphy original;
    private FixedHeight fixedHeight;

    public OriginalGiphy getOriginal() {
        return this.original;
    }

    public void setOriginal(OriginalGiphy original) {
        this.original = original;
    }

    public FixedHeight getFixedHeight() {
        return this.fixedHeight;
    }
}
