package com.example.instagramgallery

import android.app.Application
import com.example.instagramgallery.di.AppComponent
import com.example.instagramgallery.di.DaggerAppComponent

class App : Application() {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        appComponent = DaggerAppComponent.builder()
            .build()
    }

    companion object {
        lateinit var instance: App

        fun instance(): App {
            return instance
        }
    }

    fun getAppComponent(): AppComponent {
        return appComponent
    }

}