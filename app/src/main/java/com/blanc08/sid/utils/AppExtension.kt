package com.blanc08.sid.utils

import android.util.Log
import com.blanc08.sid.BuildConfig
import com.blanc08.sid.data.TAG_DEBUG
import com.blanc08.sid.data.TAG_ERROR

fun logDebug(message: String) {
    if (BuildConfig.DEBUG) {
        Log.d(TAG_DEBUG, message)
    }
}

fun logError(message: String) {
    if (BuildConfig.DEBUG) {
        Log.e(TAG_ERROR, message)
    }
}