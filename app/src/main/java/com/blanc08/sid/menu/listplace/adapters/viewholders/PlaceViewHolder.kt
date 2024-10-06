package com.blanc08.sid.menu.listplace.adapters.viewholders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.blanc08.sid.databinding.ItemListPlaceBinding
import com.blanc08.sid.menu.listplace.models.PlaceModel
import com.blanc08.sid.menu.listplace.viewmodels.ItemListPlaceViewModel

class PlaceViewHolder(val binding: ItemListPlaceBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(placeModel: PlaceModel) {
        binding.itemListPlace = ItemListPlaceViewModel(placeModel)
        binding.executePendingBindings()
    }

    companion object {
        fun from(parent: ViewGroup): PlaceViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = ItemListPlaceBinding.inflate(inflater, parent, false)
            return PlaceViewHolder(binding)
        }
    }

}