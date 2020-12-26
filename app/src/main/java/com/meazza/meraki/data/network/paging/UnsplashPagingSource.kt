package com.meazza.meraki.data.network.paging

import androidx.paging.PagingSource
import com.meazza.meraki.data.network.response.UnsplashPhoto
import com.meazza.meraki.data.network.service.UnsplashService
import com.meazza.meraki.util.Constants.UNSPLASH_STARTING_PAGE_INDEX
import retrofit2.HttpException
import java.io.IOException

class UnsplashPagingSource(
    private val unsplashService: UnsplashService,
    private val query: String
) : PagingSource<Int, UnsplashPhoto>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UnsplashPhoto> {

        val position = params.key ?: UNSPLASH_STARTING_PAGE_INDEX

        return try {

            val response = unsplashService.searchPhotos(query, position, params.loadSize)
            val photos = response.results

            LoadResult.Page(
                data = photos,
                prevKey = if (position == UNSPLASH_STARTING_PAGE_INDEX) null else position - 1,
                nextKey = if (photos.isEmpty()) null else position + 1
            )

        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }
    }
}