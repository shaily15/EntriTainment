package com.shaily.entritainment.presentation.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shaily.entritainment.domain.usecase.GetPopularMovieUseCase
import com.shaily.entritainment.domain.usecase.GetTopRatedMovieUseCase
import com.shaily.entritainment.domain.usecase.GetUpcomingMovieUseCase
import com.shaily.entritainment.presentation.HomeStateHolder
import com.shaily.entritainment.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val getPopularMovieUseCase: GetPopularMovieUseCase,
    private val getUpcomingMovieUseCase: GetUpcomingMovieUseCase,
    private val getTopRatedMovieUseCase: GetTopRatedMovieUseCase
    ) : ViewModel() {

    val popularMovies = mutableStateOf(HomeStateHolder())
    val upcomingMovies = mutableStateOf(HomeStateHolder())
    val topRatedMovies = mutableStateOf(HomeStateHolder())

    init {
        getPopularMovies()
        getUpcomingMovies()
        getTopRatedMovies()
    }

    private fun getPopularMovies() {
        getPopularMovieUseCase().onEach {
            when (it) {
                is Resource.Loading -> {
                    popularMovies.value = HomeStateHolder(isLoading = true)
                }
                is Resource.Success -> {
                    popularMovies.value = it.data?.let { it1 -> HomeStateHolder(data = it1) }!!
                }
                is Resource.Error -> {
                    popularMovies.value = HomeStateHolder(error = it.message.toString())
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun getUpcomingMovies() {
        getUpcomingMovieUseCase().onEach {
            when (it) {
                is Resource.Loading -> {
                    upcomingMovies.value = HomeStateHolder(isLoading = true)
                }
                is Resource.Success -> {
                    upcomingMovies.value = it.data?.let { it1 -> HomeStateHolder(data = it1) }!!
                }
                is Resource.Error -> {
                    upcomingMovies.value = HomeStateHolder(error = it.message.toString())
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun getTopRatedMovies() {
        getTopRatedMovieUseCase().onEach {
            when (it) {
                is Resource.Loading -> {
                    topRatedMovies.value = HomeStateHolder(isLoading = true)
                }
                is Resource.Success -> {
                    topRatedMovies.value = it.data?.let { it1 -> HomeStateHolder(data = it1) }!!
                }
                is Resource.Error -> {
                    topRatedMovies.value = HomeStateHolder(error = it.message.toString())
                }
            }
        }.launchIn(viewModelScope)
    }
}