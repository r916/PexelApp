package com.example.pexelapp.repository

class Repository {

    fun getPhotos(query: String, page: Int, perPage: Int) =
        RetrofitInstance.api.getPhotos(query, page, perPage)

}