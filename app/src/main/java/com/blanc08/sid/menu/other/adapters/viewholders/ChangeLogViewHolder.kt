package com.blanc08.sid.menu.other.adapters.viewholders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.blanc08.sid.databinding.ItemChangelogBinding
import com.blanc08.sid.menu.other.models.ChangeLogModel
import com.blanc08.sid.menu.other.viewmodels.ItemChangeLogViewModel

class ChangeLogViewHolder(val binding: ItemChangelogBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(changeLogModel: ChangeLogModel) {
        binding.itemChangelog = ItemChangeLogViewModel(changeLogModel)
        binding.executePendingBindings()
    }

    companion object {
        fun from(parent: ViewGroup): ChangeLogViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = ItemChangelogBinding.inflate(inflater, parent, false)
            return ChangeLogViewHolder(binding)
        }
    }

}