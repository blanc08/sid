package com.blanc08.sid

import android.app.Application
import com.blanc08.sid.utils.PreferencesHelper

/**
 *  Updated by blanc08 on 02 June 2021.
 */
class App : Application() {

    companion object {
        var prefHelper: PreferencesHelper? = null
    }

    override fun onCreate() {
        super.onCreate()
        prefHelper = PreferencesHelper(this)
    }

}