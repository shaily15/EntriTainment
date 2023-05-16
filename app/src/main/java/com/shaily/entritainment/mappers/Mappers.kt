package com.shaily.entritainment.mappers

import com.shaily.entritainment.data.model.MovieDTO
import com.shaily.entritainment.domain.model.Movie
import com.shaily.entritainment.utils.Constants

fun List<MovieDTO>.toDomain(): List<Movie> {
    return map {
        Movie(
            backdropPath = Constants.IMAGE_BASE_URL_W500 + it.backdrop_path,
            id = it.id ?: 0,
            originalTitle = it.original_title ?: "",
            popularity = it.popularity ?: 1.0,
            posterPath = Constants.IMAGE_BASE_URL_W500 + it.poster_path,
            releaseDate = it.release_date ?: ""
        )

    }
}