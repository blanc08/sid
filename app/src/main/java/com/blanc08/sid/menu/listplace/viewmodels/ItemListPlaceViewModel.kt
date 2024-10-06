package com.blanc08.sid.menu.listplace.viewmodels

import androidx.lifecycle.ViewModel
import androidx.databinding.ObservableField
import com.blanc08.sid.menu.listplace.models.PlaceModel

class ItemListPlaceViewModel(placeModel: PlaceModel) : ViewModel() {

    var name: ObservableField<String> = ObservableField(placeModel.name)
    var location: ObservableField<String> = ObservableField(placeModel.location)
    var imageUrl: ObservableField<String> = ObservableField(placeModel.image)

}