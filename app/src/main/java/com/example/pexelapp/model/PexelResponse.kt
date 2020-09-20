package com.example.pexelapp.model

data class PexelResponse(
    val next_page: String,
    val page: Int,
    val per_page: Int,
    val photos: List<Photo>,
    val total_results: Int
)