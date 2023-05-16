package com.shaily.entritainment.domain.di

import com.shaily.entritainment.data.network.MoviesApiService
import com.shaily.entritainment.data.repositories.GetPopularMoviesRepoImpl
import com.shaily.entritainment.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DomainModule {

    @Provides
    fun providesMovieRepo(moviesApiService: MoviesApiService): MovieRepository {
        return GetPopularMoviesRepoImpl(moviesApiService)
    }
}