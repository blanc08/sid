package com.blanc08.sid.menu.other.views

import androidx.databinding.DataBindingUtil
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.blanc08.sid.R
import com.blanc08.sid.databinding.ChildFragmentLibrariesBinding
import com.blanc08.sid.menu.other.adapters.LicenseAdapter
import com.blanc08.sid.menu.other.viewmodels.ChildFragmentLibrariesViewModel

class ChildFragmentLibraries : Fragment() {

    companion object {
        fun getInstance(): Fragment {
            return ChildFragmentLibraries()
        }
    }

    private lateinit var binding: ChildFragmentLibrariesBinding
    private lateinit var viewModel: ChildFragmentLibrariesViewModel
    private lateinit var adapter: LicenseAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.child_fragment_libraries, container, false)
        viewModel = ViewModelProvider(this)[ChildFragmentLibrariesViewModel::class.java]
        binding.libraries = viewModel

        setupRecycler()
        viewModel.setupData(context)
        viewModel.listData.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
        return binding.root
    }

    private fun setupRecycler() {
        adapter = LicenseAdapter()
        binding.recyclerViewLicense.adapter = adapter
    }

}