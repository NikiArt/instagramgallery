package com.example.instagramgallery.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.instagramgallery.R
import com.example.instagramgallery.presenters.GalleryPresenter
import com.example.instagramgallery.views.GalleryItemView
import javax.inject.Inject

class GalleryAdapter : RecyclerView.Adapter<GalleryAdapter.MyViewHolder>() {

    @Inject
    lateinit var presenter: GalleryPresenter


    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view), GalleryItemView {
        var currentPos = 0

        override fun getPos(): Int {
            return currentPos
        }

        override fun setImage(imageUrl: String) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.gallery_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.currentPos = position
        presenter.bind(holder)
    }
}