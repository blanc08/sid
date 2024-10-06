package com.blanc08.sid.menu.gallery.viewmodels

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.blanc08.sid.menu.gallery.models.GalleryModel
import com.blanc08.sid.networks.db.repositories.DbGalleryRepository

class FragmentGalleryViewModel(application: Application) : AndroidViewModel(application) {

    private val dbGallery = DbGalleryRepository(application.applicationContext, viewModelScope)
    var dataGallery: MutableLiveData<List<GalleryModel>> = MutableLiveData()

    init {
        dbGallery.galleries {
            it?.let { galleries ->
                dataGallery.postValue(galleries)
            }
        }
    }

}