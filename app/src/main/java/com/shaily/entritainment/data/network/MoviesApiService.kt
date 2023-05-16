package com.shaily.entritainment.data.network

import com.shaily.entritainment.data.model.PopularMoviesDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApiService {

    // https://api.themoviedb.org/3/movie/popular?api_key=37b202d69376468e10d4025151c1752f
    @GET("popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String = "37b202d69376468e10d4025151c1752f"
    ): Response<PopularMoviesDTO>

}