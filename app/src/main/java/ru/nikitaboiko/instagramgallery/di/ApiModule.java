package ru.nikitaboiko.instagramgallery.di;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.nikitaboiko.instagramgallery.model.DataGetter;

@Module
public class ApiModule {

    @Provides
    public String getUrl() {
        return "http://api.giphy.com/v1/";
    }

    @Provides
    public OkHttpClient getOkHttpClient() {
        return new OkHttpClient.Builder()
                .build();
    }

    @Provides
    public Gson getGson() {
        return new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
    }

    @Provides
    public Retrofit getRetrofitApi(OkHttpClient okHttpClient, Gson gson, String baseUrl) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    @Singleton
    @Provides
    public DataGetter getData() {
        return new DataGetter();
    }
}
