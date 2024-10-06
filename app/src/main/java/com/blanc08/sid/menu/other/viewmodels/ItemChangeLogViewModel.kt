package com.blanc08.sid.menu.other.viewmodels

import androidx.lifecycle.ViewModel
import androidx.databinding.ObservableField
import com.blanc08.sid.menu.other.models.ChangeLogModel
import com.blanc08.sid.utils.AppHelper

class ItemChangeLogViewModel(changeLogModel: ChangeLogModel) : ViewModel() {

    var name: ObservableField<String> = ObservableField(changeLogModel.title!!)
    var description: ObservableField<String> = ObservableField(AppHelper.fromHtml(changeLogModel.description!!))
    var isLast: ObservableField<Boolean> = ObservableField(changeLogModel.isLast!!)

}