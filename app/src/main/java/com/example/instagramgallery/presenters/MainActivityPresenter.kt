package com.example.instagramgallery.presenters

import androidx.fragment.app.Fragment
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.instagramgallery.ui.activities.FavouritesFragment
import com.example.instagramgallery.ui.activities.GalleryFragment
import com.example.instagramgallery.views.MainView

@InjectViewState
class MainActivityPresenter : MvpPresenter<MainView>(), ActivityPresenter {


    val favouritesFragment = FavouritesFragment()
    val galleryFragment = GalleryFragment()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

    }

    fun changeFragment(fragment: Int) {
        viewState.changeFragment(getCurrentFragment(fragment))
    }

    private fun getCurrentFragment(fragmentNumber: Int): Fragment {
        return when (fragmentNumber) {
            1 -> galleryFragment
            2 -> favouritesFragment
            else -> galleryFragment
        }
    }
}