package com.shaily.entritainment.presentation

import com.shaily.entritainment.domain.model.Movie

data class HomeStateHolder(
    val isLoading: Boolean = false,
    val data: List<Movie> = emptyList(),
    val error: String = ""
)
