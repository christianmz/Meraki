package com.meazza.meraki.data.repository

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import com.meazza.meraki.data.network.response.UnsplashPhoto

interface NetworkRepository {
    fun getResult(query: String): LiveData<PagingData<UnsplashPhoto>>
}