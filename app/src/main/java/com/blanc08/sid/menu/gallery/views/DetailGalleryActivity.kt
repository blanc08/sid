package com.blanc08.sid.menu.gallery.views

import androidx.databinding.DataBindingUtil
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.navigation.navArgs
import com.blanc08.sid.R
import com.blanc08.sid.databinding.ActivityDetailGalleryBinding
import com.blanc08.sid.menu.gallery.viewmodels.DetailGalleryViewModel
import com.blanc08.sid.utils.binding.ViewModelFactory

class DetailGalleryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailGalleryBinding
    private val viewModel: DetailGalleryViewModel by viewModels { ViewModelFactory(args.galleryModel) }

    private val args: DetailGalleryActivityArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail_gallery)
        binding.lifecycleOwner = this
        binding.gallery = viewModel

        setupToolbar()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressedDispatcher.onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.toolbarDetailGallery.toolbarInclude)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        binding.toolbarDetailGallery.textViewToolbarInclude.text = getString(R.string.detail_gallery)
    }

}