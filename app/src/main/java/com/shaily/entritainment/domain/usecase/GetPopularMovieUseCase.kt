package com.shaily.entritainment.domain.usecase

import android.util.Log
import com.shaily.entritainment.domain.model.Movie
import com.shaily.entritainment.domain.repository.MovieRepository
import com.shaily.entritainment.mappers.toDomain
import com.shaily.entritainment.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetPopularMovieUseCase @Inject constructor(
    private val
    repository: MovieRepository
) {
    operator fun invoke(): Flow<Resource<List<Movie>>> = flow {
        emit(Resource.Loading(""))
        try {
            Log.d("imageUrl 2 ", repository.getPopularMovie().toString())
            emit(Resource.Success(repository.getPopularMovie()))
        } catch (e: Exception) {
            emit(Resource.Error(e.message))
        }
    }
}