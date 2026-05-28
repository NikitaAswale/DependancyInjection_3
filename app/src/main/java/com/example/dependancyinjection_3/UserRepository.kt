package com.example.dependancyinjection_3

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class UserRepository @Inject constructor(private val apiService: APIService){

    fun getPosts(): Flow<PagingData<Result>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                PagingSource(apiService)
            }
        ).flow
    }
}