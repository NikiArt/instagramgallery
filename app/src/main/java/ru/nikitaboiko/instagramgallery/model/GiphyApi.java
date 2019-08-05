package ru.nikitaboiko.instagramgallery.model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ru.nikitaboiko.instagramgallery.model.parsingJson.ResponseGiphy;

public interface GiphyApi {
    @GET("gifs/search?")
    Call<ResponseGiphy> getGiphies(@Query("api_key") String apiKey, @Query("q") String search);
}
