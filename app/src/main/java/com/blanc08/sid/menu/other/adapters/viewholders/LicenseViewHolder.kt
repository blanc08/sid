package com.blanc08.sid.menu.other.adapters.viewholders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.blanc08.sid.databinding.ItemLibrariesBinding
import com.blanc08.sid.menu.other.models.LicenseModel
import com.blanc08.sid.menu.other.viewmodels.ItemLibrariesViewModel

class LicenseViewHolder(val binding: ItemLibrariesBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(licenseModel: LicenseModel) {
        binding.itemLibraries = ItemLibrariesViewModel(licenseModel)
        binding.executePendingBindings()
    }

    companion object {
        fun from(parent: ViewGroup): LicenseViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = ItemLibrariesBinding.inflate(inflater, parent, false)
            return LicenseViewHolder(binding)
        }
    }

}