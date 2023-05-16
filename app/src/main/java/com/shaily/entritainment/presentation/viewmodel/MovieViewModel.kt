package com.shaily.entritainment.presentation.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shaily.entritainment.domain.usecase.GetPopularMovieUseCase
import com.shaily.entritainment.presentation.HomeStateHolder
import com.shaily.entritainment.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(private val getPopularMovieUseCase: GetPopularMovieUseCase) :
    ViewModel() {

    val movies = mutableStateOf(HomeStateHolder())

    init {
        getPopularMovies()
    }

    fun getPopularMovies() {
        getPopularMovieUseCase().onEach {
            when (it) {
                is Resource.Loading -> {
                    movies.value = HomeStateHolder(isLoading = true)
                }
                is Resource.Success -> {
                    movies.value = it.data?.let { it1 -> HomeStateHolder(data = it1) }!!
                }
                is Resource.Error -> {
                    movies.value = HomeStateHolder(error = it.message.toString())
                }
            }
        }.launchIn(viewModelScope)
    }
}