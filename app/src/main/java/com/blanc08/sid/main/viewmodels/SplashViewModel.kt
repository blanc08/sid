package com.blanc08.sid.main.viewmodels

import android.app.Activity
import android.app.Application
import android.content.Intent
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.blanc08.sid.BuildConfig
import com.blanc08.sid.R
import com.blanc08.sid.main.MainActivity
import com.blanc08.sid.networks.AppRepository
import com.blanc08.sid.networks.db.repositories.DbGalleryRepository
import com.blanc08.sid.networks.db.repositories.DbPinRepository
import com.blanc08.sid.networks.db.repositories.DbPlaceRepository
import com.blanc08.sid.utils.AppHelper
import kotlinx.coroutines.launch

class SplashViewModel(application: Application) : AndroidViewModel(application) {

    private val dbPlaceRepository = DbPlaceRepository(application.applicationContext, viewModelScope)
    private val dbGalleryRepository = DbGalleryRepository(application.applicationContext, viewModelScope)
    private val dbPinRepository = DbPinRepository(application.applicationContext, viewModelScope)
    private val repo = AppRepository()

    var version: ObservableField<String> = ObservableField(BuildConfig.VERSION_NAME)

    fun getAppData(activity: Activity) {
        viewModelScope.launch {
            repo.getSplashData({ places, galleries, pins ->
                viewModelScope.launch {
                    dbPlaceRepository.setupDataPlaces(places)
                    dbGalleryRepository.setupDataGalleries(galleries)
                    dbPinRepository.setupDataPins(pins)
                    goToMain(activity)
                }
            }, {
                AppHelper.displayErrorToast(activity, R.string.ops_message)
            })
        }
    }

    private fun goToMain(activity: Activity) {
        val intent = Intent(activity, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        activity.startActivity(intent)
        activity.finish()
    }

}