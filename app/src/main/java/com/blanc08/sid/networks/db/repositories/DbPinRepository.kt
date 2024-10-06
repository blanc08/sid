package com.blanc08.sid.networks.db.repositories

import android.content.Context
import com.blanc08.sid.menu.maps.models.PinModel
import com.blanc08.sid.networks.db.AppDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class DbPinRepository(context: Context, private val scope: CoroutineScope) {

    private val dbPin = AppDatabase.getInstance(context)?.pinDaoAccess()

    fun pins(pins: (List<PinModel>?) -> Unit) {
        scope.launch {
            pins(dbPin?.pins())
        }
    }

    suspend fun setupDataPins(pins: (List<PinModel>?)) {
        dbPin?.deleteAllPin()
        pins?.forEach { pinModel ->
            dbPin?.insertPin(pinModel)
        }
    }

}