package com.meazza.meraki.data.repository

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.meazza.meraki.data.network.paging.UnsplashPagingSource
import com.meazza.meraki.data.network.response.UnsplashPhoto
import com.meazza.meraki.data.network.service.UnsplashService
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

@ActivityRetainedScoped
class NetworkRepositoryImpl @Inject constructor(private val unsplashService: UnsplashService) :
    NetworkRepository {

    override fun getResult(query: String): LiveData<PagingData<UnsplashPhoto>> =
        Pager(
            config = PagingConfig(
                pageSize = 20,
                maxSize = 100,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { UnsplashPagingSource(unsplashService, query) }
        ).liveData
}