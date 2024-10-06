package com.blanc08.sid.menu.listplace.viewmodels

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.blanc08.sid.data.PlaceLocation
import com.blanc08.sid.menu.listplace.models.PlaceModel
import com.blanc08.sid.networks.db.repositories.DbPlaceRepository

class FragmentListPlaceViewModel(application: Application) : AndroidViewModel(application) {

    private val dbPlaceRepository = DbPlaceRepository(application.applicationContext, viewModelScope)

    var listPlace: MutableLiveData<List<PlaceModel>> = MutableLiveData()

    fun getListPlace(placeLocation: PlaceLocation) {
        if (placeLocation == PlaceLocation.ALL) {
            dbPlaceRepository.places {
                listPlace.postValue(it)
            }
        } else {
            dbPlaceRepository.placesByLocation(placeLocation.toString()) {
                listPlace.postValue(it)
            }
        }
    }

}