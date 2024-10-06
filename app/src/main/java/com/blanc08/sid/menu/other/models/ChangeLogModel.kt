package com.blanc08.sid.menu.other.models

import com.google.errorprone.annotations.Keep

@Keep
data class ChangeLogModel(
    val title: String?,
    val description: String?,
    val isLast: Boolean?
)