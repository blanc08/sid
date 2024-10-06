package com.blanc08.sid.utils.binding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.blanc08.sid.menu.gallery.models.GalleryModel
import com.blanc08.sid.menu.gallery.viewmodels.DetailGalleryViewModel
import com.blanc08.sid.menu.listplace.models.PlaceModel
import com.blanc08.sid.menu.listplace.viewmodels.DetailListPlaceViewModel

class ViewModelFactory(private val any: Any) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass == DetailListPlaceViewModel::class.java) {
            return DetailListPlaceViewModel(any as PlaceModel) as T
        } else if (modelClass == DetailGalleryViewModel::class.java) {
            return DetailGalleryViewModel(any as GalleryModel) as T
        }
        return super.create(modelClass)
    }
}