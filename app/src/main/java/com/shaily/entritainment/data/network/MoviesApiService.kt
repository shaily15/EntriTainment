package com.shaily.entritainment.data.network

import com.shaily.entritainment.data.model.PopularMoviesDTO
import com.shaily.entritainment.utils.Constants.MOVIE_API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApiService {

    // https://api.themoviedb.org/3/movie/popular?api_key=37b202d69376468e10d4025151c1752f
    @GET("popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String = MOVIE_API_KEY
    ): Response<PopularMoviesDTO>

    @GET("upcoming")
    suspend fun getUpcomingMovies(
        @Query("api_key") apiKey: String = MOVIE_API_KEY
    ): Response<PopularMoviesDTO>

    @GET("top_rated")
    suspend fun getTopRatedMovies(
        @Query("api_key") apiKey: String = MOVIE_API_KEY
    ): Response<PopularMoviesDTO>

}