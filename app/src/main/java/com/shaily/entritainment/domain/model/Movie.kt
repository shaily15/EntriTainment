package com.shaily.entritainment.domain.model

data class Movie(
    val backdropPath: String,
    val id: Int,
    val originalTitle: String,
    val popularity: Double,
    val posterPath: String,
    val releaseDate: String,
)
