package com.example.pexelapp.model

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

const val STANDARD_PAGE_SIZE = 15
const val API_KEY = "563492ad6f91700001000001b9f19510c5f7423291311abee24b91e4"

interface PexelAPI {

    @GET("v1/search")
    fun getPhotos(
        @Query("query") query: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int = STANDARD_PAGE_SIZE,
        @Header("Authorization") Authorization: String = API_KEY
    ): Response<PexelResponse>

}