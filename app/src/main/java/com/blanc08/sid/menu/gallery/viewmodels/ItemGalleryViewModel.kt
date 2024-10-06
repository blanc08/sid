package com.blanc08.sid.menu.gallery.viewmodels

import androidx.lifecycle.ViewModel
import androidx.databinding.ObservableField
import com.blanc08.sid.menu.gallery.models.GalleryModel

class ItemGalleryViewModel(galleryModel: GalleryModel) : ViewModel() {
    var imageUrl: ObservableField<String> = ObservableField(galleryModel.thumbnail)
}