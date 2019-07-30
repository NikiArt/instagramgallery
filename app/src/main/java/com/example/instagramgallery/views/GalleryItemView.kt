package com.example.instagramgallery.views

import androidx.annotation.NonNull

interface GalleryItemView {

    fun getPos(): Int
    fun setImage(@NonNull imageUrl: String)
}