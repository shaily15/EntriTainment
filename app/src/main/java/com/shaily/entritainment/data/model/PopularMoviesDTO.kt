package com.shaily.entritainment.data.model

data class PopularMoviesDTO(
    val page: Int?,
    val results: List<MovieDTO>?,
    val total_pages: Int?,
    val total_results: Int?
)