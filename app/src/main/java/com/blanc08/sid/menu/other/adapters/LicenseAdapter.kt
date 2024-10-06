package com.blanc08.sid.menu.other.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.blanc08.sid.menu.other.adapters.viewholders.LicenseViewHolder
import com.blanc08.sid.menu.other.models.LicenseModel
import com.blanc08.sid.utils.AdapterCallback

class LicenseAdapter : ListAdapter<LicenseModel, LicenseViewHolder>
    (AdapterCallback.diffLicenseCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LicenseViewHolder {
        return LicenseViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: LicenseViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}