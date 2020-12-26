package com.meazza.meraki.ui.gallery.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.meazza.meraki.R
import com.meazza.meraki.data.network.response.UnsplashPhoto
import com.meazza.meraki.databinding.LayoutItemPhotoBinding

object UnsplashPhotoAdapter :
    PagingDataAdapter<UnsplashPhoto, UnsplashPhotoAdapter.UnsplashViewHolder>(UnsplashPhotoDiffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = UnsplashViewHolder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.layout_item_photo,
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: UnsplashViewHolder, position: Int) {
        holder.itemBinding.run {
            photo = getItem(position)
        }
    }

    class UnsplashViewHolder(val itemBinding: LayoutItemPhotoBinding) :
        RecyclerView.ViewHolder(itemBinding.root)
}