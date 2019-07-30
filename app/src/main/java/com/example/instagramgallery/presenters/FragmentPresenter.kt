package com.example.instagramgallery.presenters

import com.example.instagramgallery.views.GalleryItemView

interface FragmentPresenter {
    fun bind(view: GalleryItemView)

    fun getCount(): Int

}