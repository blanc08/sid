package com.blanc08.sid.menu.gallery.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.blanc08.sid.menu.gallery.adapters.viewholders.GalleryViewHolder
import com.blanc08.sid.menu.gallery.models.GalleryModel
import com.blanc08.sid.utils.AdapterCallback

/**
 *  Updated by blanc08 on 26 July 2020.
 */
class GalleryAdapter(val onItemClick: (galleryModel: GalleryModel) -> Unit) :
    ListAdapter<GalleryModel, GalleryViewHolder>(AdapterCallback.diffGalleryCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryViewHolder {
        return GalleryViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: GalleryViewHolder, position: Int) {
        val galleryModel = getItem(position)
        holder.bind(galleryModel)
        holder.itemView.setOnClickListener {
            onItemClick(galleryModel)
        }
    }

}