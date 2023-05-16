package com.shaily.entritainment.data.repositories

import android.util.Log
import com.shaily.entritainment.data.network.MoviesApiService
import com.shaily.entritainment.domain.model.Movie
import com.shaily.entritainment.domain.repository.MovieRepository
import com.shaily.entritainment.mappers.toDomain
import com.shaily.entritainment.utils.SafeApiRequest
import javax.inject.Inject

class GetPopularMoviesRepoImpl @Inject constructor(
    private val moviesApiService: MoviesApiService
): MovieRepository, SafeApiRequest() {

    override suspend fun getPopularMovie(): List<Movie> {
       val response = safeApiRequest { moviesApiService.getPopularMovies() }
        Log.d("imageUrl 1 ", response.results.toString())
        return response.results?.toDomain()!!
    }
}