package com.example.dependancyinjection_3

import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {

    @GET("character")
    suspend fun getPosts(
        @Query("page")page : Int
    ): Users
}