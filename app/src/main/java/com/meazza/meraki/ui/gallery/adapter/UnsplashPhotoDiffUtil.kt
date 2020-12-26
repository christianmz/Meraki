package com.meazza.meraki.ui.gallery.adapter

import androidx.recyclerview.widget.DiffUtil
import com.meazza.meraki.data.network.response.UnsplashPhoto

object UnsplashPhotoDiffUtil : DiffUtil.ItemCallback<UnsplashPhoto>() {

    override fun areItemsTheSame(oldItem: UnsplashPhoto, newItem: UnsplashPhoto): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: UnsplashPhoto, newItem: UnsplashPhoto): Boolean =
        oldItem == newItem
}