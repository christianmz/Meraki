package com.meazza.meraki.data.repository

import androidx.paging.PagingData
import com.meazza.meraki.data.network.response.UnsplashPhoto
import kotlinx.coroutines.flow.Flow

interface NetworkRepository {

    fun getResult(query: String): Flow<PagingData<UnsplashPhoto>>
}