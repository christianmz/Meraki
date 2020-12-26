package com.meazza.meraki.util

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory
import com.meazza.meraki.R

fun ImageView.loadUrl(url: String?) {

    val factory: DrawableCrossFadeFactory = DrawableCrossFadeFactory.Builder()
        .setCrossFadeEnabled(true).build()

    Glide.with(this.context)
        .load(url)
        .centerCrop()
        .transition(DrawableTransitionOptions.withCrossFade(factory))
        .error(R.color.white)
        .override(600, 600)
        .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
        .into(this)
        .waitForLayout()
}