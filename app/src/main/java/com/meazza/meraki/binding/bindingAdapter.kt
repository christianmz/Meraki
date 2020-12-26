package com.meazza.meraki.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.meazza.meraki.util.loadUrl

@BindingAdapter("setImage")
fun setImage(imageView: ImageView, url: String?) {
    imageView.loadUrl(url)
}