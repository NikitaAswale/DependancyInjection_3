package com.example.dependancyinjection_3

import retrofit2.http.GET
import retrofit2.http.Query

interface EndpointAPIService {

    @GET("posts")
    suspend fun getEndpoint(@Query("userId") userId: Int): List<Endpoint>
}