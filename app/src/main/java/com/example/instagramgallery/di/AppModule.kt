package com.example.instagramgallery.di

import com.example.instagramgallery.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Singleton
@Module
class AppModule(private val app: App) {

    @Provides
    fun app(): App {
        return app
    }
}