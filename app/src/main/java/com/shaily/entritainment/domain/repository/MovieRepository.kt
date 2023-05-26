package com.shaily.entritainment.domain.repository

import com.shaily.entritainment.domain.model.Movie

interface MovieRepository {

    suspend fun getPopularMovie(): List<Movie>
    suspend fun getUpcomingMovie(): List<Movie>
    suspend fun getTopRatedMovie(): List<Movie>


}