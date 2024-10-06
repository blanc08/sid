package com.blanc08.sid.menu.gallery.viewmodels

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.blanc08.sid.menu.gallery.models.GalleryModel

class DetailGalleryViewModel(galleryModel: GalleryModel?) : ViewModel() {

    var imageUrl: ObservableField<String> = ObservableField(galleryModel?.image)
    var caption: ObservableField<String> = ObservableField(galleryModel?.caption)

}