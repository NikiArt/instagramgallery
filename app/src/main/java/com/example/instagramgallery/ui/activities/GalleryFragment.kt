package com.example.instagramgallery.ui.activities


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter

import com.example.instagramgallery.R
import com.example.instagramgallery.presenters.GalleryPresenter

class GalleryFragment : MvpAppCompatFragment() {

    @InjectPresenter
    lateinit var galleryPresenter: GalleryPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_gallery, container, false)
    }


}
