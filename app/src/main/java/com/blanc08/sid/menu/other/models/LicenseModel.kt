package com.blanc08.sid.menu.other.models

import com.google.errorprone.annotations.Keep

@Keep
data class LicenseModel(
    val title: String?,
    val url: String?,
    val license: String?,
    val isLast: Boolean?
)