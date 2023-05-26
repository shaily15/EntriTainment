package com.shaily.entritainment.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.shaily.entritainment.R
import com.shaily.entritainment.domain.model.Movie
import com.shaily.entritainment.presentation.components.MovieImage
import com.shaily.entritainment.presentation.viewmodel.MovieViewModel


private const val COLUMN_COUNT = 2
@Composable
fun HomeScreen(
    viewModel: MovieViewModel = hiltViewModel()) {

    MainHomeScreenUI(viewModel)
}

@Composable
fun MovieItem(movie: Movie, onItemClick: () -> Unit) {
    Column(modifier = Modifier) {
        MovieImage(
            imageUrl = movie.posterPath,
            modifier = Modifier
                .height(300.dp)
                .padding(16.dp)
                .fillMaxWidth()
        )

        Text(text = movie.originalTitle,
            style = androidx.compose.ui.text.TextStyle(color = Color.Gray, fontWeight = FontWeight.SemiBold, fontSize = 20.sp),
            modifier = Modifier.padding(12.dp)
        )
        Spacer(modifier = Modifier.height(12.dp))
    }
}

@Composable
fun MainHomeScreenUI(
    viewModel: MovieViewModel) {
    Scaffold(
        topBar = { HomeScreenAppBar() },
        content = { it ->
            Content(viewModel)
            it.calculateTopPadding()
        }
    )
}

@Composable
fun HomeScreenAppBar() {
    TopAppBar(
        title = {
            Text(
                text = stringResource(R.string.app_name),
                color = Color.LightGray
            )
        },
        backgroundColor = Color.Black,
        navigationIcon = {
            IconButton(onClick = { /* Handle navigation icon click */ }) {
                Icon(Icons.Filled.Menu, contentDescription = "Menu", tint = Color.LightGray)
            }
        },
        actions = {
            IconButton(onClick = { /* Handle action click */ }) {
                Icon(Icons.Default.Favorite, contentDescription = "Favorite", tint = Color.LightGray)
            }
        }
    )
}

@Composable
fun Content(viewModel: MovieViewModel) {
    val popularMovieResponse = viewModel.popularMovies.value

    if (popularMovieResponse.isLoading) {
        Box(modifier = Modifier.fillMaxSize()) {
            CircularProgressIndicator( modifier = Modifier.align(Alignment.Center) )
        }
    }

    if(popularMovieResponse.error.isNotBlank()) {
        Box(modifier = Modifier.fillMaxSize()) {
            Text(text = popularMovieResponse.error, modifier = Modifier.align(Alignment.Center))
        }
    }


    popularMovieResponse.data.let {
        LazyVerticalGrid(columns = GridCells.Fixed(COLUMN_COUNT),
            contentPadding = PaddingValues(8.dp),
            content = ({
                items(items = it,  itemContent = {
                        item ->
                    MovieItem(movie = item, onItemClick = {
                    })
                })
            }))
        Spacer(modifier = Modifier.height(16.dp))
    }
}