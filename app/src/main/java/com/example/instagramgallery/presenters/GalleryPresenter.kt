package com.example.instagramgallery.presenters

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.instagramgallery.views.GalleryItemView
import com.example.instagramgallery.views.GalleryView

@InjectViewState
class GalleryPresenter : MvpPresenter<GalleryView>(), FragmentPresenter {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        val vs = viewState
    }

    override fun bind(view: GalleryItemView) {
        view.setImage("blank")
    }

    override fun getCount(): Int {
        return 0
    }

}