package com.shaily.entritainment.domain.usecase

import com.shaily.entritainment.domain.model.Movie
import com.shaily.entritainment.domain.repository.MovieRepository
import com.shaily.entritainment.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetTopRatedMovieUseCase @Inject constructor(
    private val repository: MovieRepository
) {

    operator fun invoke(): Flow<Resource<List<Movie>>> = flow {
        emit(Resource.Loading("Loading..."))
        try {
            emit(Resource.Success(repository.getTopRatedMovie()))
        } catch (e: Exception) {
            emit(Resource.Error(e.message))
        }
    }
}