package com.blanc08.sid.menu.maps.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.blanc08.sid.menu.maps.models.PinModel
import com.blanc08.sid.networks.db.repositories.DbPinRepository

class FragmentMapsViewModel(application: Application) : AndroidViewModel(application) {

    private val dbPin = DbPinRepository(application.applicationContext, viewModelScope)

    var listPin: MutableLiveData<List<PinModel>> = MutableLiveData()

    fun getListPin() {
        dbPin.pins {
            listPin.postValue(it)
        }
    }

}