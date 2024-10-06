package com.blanc08.sid.menu.listplace.views

import androidx.databinding.DataBindingUtil
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.navigation.navArgs
import com.blanc08.sid.R
import com.blanc08.sid.databinding.ActivityDetailListplaceBinding
import com.blanc08.sid.menu.listplace.viewmodels.DetailListPlaceViewModel
import com.blanc08.sid.utils.binding.ViewModelFactory

class DetailListPlaceActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailListplaceBinding
    private val viewModel: DetailListPlaceViewModel by viewModels { ViewModelFactory(args.placeModel) }

    private val args: DetailListPlaceActivityArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail_listplace)
        binding.lifecycleOwner = this
        binding.listPlace = viewModel

        setupToolbar()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressedDispatcher.onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.toolbarDetailListPlace.toolbarInclude)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        binding.toolbarDetailListPlace.textViewToolbarInclude.text = getString(R.string.detail_list_place)
    }

}