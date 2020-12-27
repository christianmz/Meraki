package com.meazza.meraki.ui.gallery

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.meazza.meraki.R
import com.meazza.meraki.databinding.FragmentGalleryBinding
import com.meazza.meraki.ui.gallery.adapter.UnsplashPhotoLoadStateAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GalleryFragment : Fragment(R.layout.fragment_gallery) {

    private val galleryViewModel by activityViewModels<GalleryViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        DataBindingUtil.bind<FragmentGalleryBinding>(view)?.apply {
            lifecycleOwner = this@GalleryFragment
            viewModel = galleryViewModel
        }

        getPhotos()
    }

    private fun getPhotos() {
        galleryViewModel.run {
            photos.observe(viewLifecycleOwner) {
                adapter.run {
                    submitData(viewLifecycleOwner.lifecycle, it)
                    withLoadStateHeaderAndFooter(
                        header = UnsplashPhotoLoadStateAdapter { retry() },
                        footer = UnsplashPhotoLoadStateAdapter { retry() }
                    )
                }
            }
        }
    }
}