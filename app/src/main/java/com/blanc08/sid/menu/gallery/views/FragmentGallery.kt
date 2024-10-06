package com.blanc08.sid.menu.gallery.views

import androidx.databinding.DataBindingUtil
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.blanc08.sid.R
import com.blanc08.sid.databinding.FragmentGalleryBinding
import com.blanc08.sid.menu.gallery.adapters.GalleryAdapter
import com.blanc08.sid.menu.gallery.models.GalleryModel
import com.blanc08.sid.menu.gallery.viewmodels.FragmentGalleryViewModel

/**
 *  Updated by blanc08 on 28 July 2020
 */
class FragmentGallery : Fragment() {

    private lateinit var binding: FragmentGalleryBinding
    private val viewModel: FragmentGalleryViewModel by activityViewModels()

    private lateinit var adapter: GalleryAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_gallery, container, false)
        binding.lifecycleOwner = this
        binding.gallery = viewModel

        setupRecyclerView()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.dataGallery.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    private fun setupRecyclerView() {
        adapter = GalleryAdapter {
            openDetailGallery(it)
        }.also {
            binding.recyclerViewGallery.adapter = it
        }
    }

    private fun openDetailGallery(galleryModel: GalleryModel) {
        val action = FragmentGalleryDirections.actionToDetailGallery(galleryModel)
        findNavController().navigate(action)
    }

}