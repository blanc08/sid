package com.blanc08.sid.menu.other.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.blanc08.sid.menu.other.adapters.viewholders.ChangeLogViewHolder
import com.blanc08.sid.menu.other.models.ChangeLogModel
import com.blanc08.sid.utils.AdapterCallback

class ChangeLogAdapter : ListAdapter<ChangeLogModel, ChangeLogViewHolder>
    (AdapterCallback.diffChangeLogCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChangeLogViewHolder {
        return ChangeLogViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ChangeLogViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}