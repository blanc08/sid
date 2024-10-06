package com.blanc08.sid.networks

import com.blanc08.sid.menu.gallery.models.GalleryModel
import com.blanc08.sid.menu.listplace.models.PlaceModel
import com.blanc08.sid.menu.maps.models.PinModel
import java.lang.Exception

class AppRepository {

    private val restApi = ServiceFactory.create()

    suspend fun getSplashData(onSuccess: (MutableList<PlaceModel>?, MutableList<GalleryModel>?, MutableList<PinModel>?) -> Unit, onError: (Exception) -> Unit) {
        try {
            val resultListPlace = restApi.listPlace()
            val resultGallery = restApi.gallery()
            val resultMapPins = restApi.mapPins()
            onSuccess(resultListPlace.body(), resultGallery.body(), resultMapPins.body())
        } catch (e: Exception) {
            onError(e)
        }
    }

}