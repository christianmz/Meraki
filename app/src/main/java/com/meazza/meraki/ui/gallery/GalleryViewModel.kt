package com.meazza.meraki.ui.gallery

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.meazza.meraki.data.repository.NetworkRepository
import com.meazza.meraki.ui.gallery.adapter.UnsplashPhotoAdapter
import com.meazza.meraki.util.Constants.DEFAULT_QUERY

class GalleryViewModel @ViewModelInject constructor(
    private val repository: NetworkRepository
) : ViewModel() {

    private val currentQuery = MutableLiveData(DEFAULT_QUERY)

    val adapter = UnsplashPhotoAdapter

    val photos = currentQuery.switchMap { queryString ->
        repository.getResult(queryString).cachedIn(viewModelScope)
    }

    fun searchPhotos(query: String) {
        currentQuery.value = query
    }
}