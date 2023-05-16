package com.shaily.entritainment.presentation.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import com.shaily.entritainment.data.model.MovieDTO
import com.shaily.entritainment.domain.model.Movie
import com.shaily.entritainment.presentation.components.MovieImage
import com.shaily.entritainment.presentation.viewmodel.MovieViewModel

@Composable
fun HomeScreen(viewModel: MovieViewModel = hiltViewModel()) {

    val response = viewModel.movies.value

    if (response.isLoading) {
        Box(modifier = Modifier.fillMaxSize()) {
            CircularProgressIndicator( modifier = Modifier.align(Alignment.Center) )
        }
    }

    if(response.error.isNotBlank()) {
        Box(modifier = Modifier.fillMaxSize()) {
            Text(text = response.error, modifier = Modifier.align(Alignment.Center))
        }
    }

    response.data.let {
        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        ){
          items(items = it,  itemContent = {
              item ->
              MovieItem(movie = item)
          })
        }
    }
}

@Composable
fun MovieItem(movie: Movie) {
    Column(modifier = Modifier) {

        MovieImage(imageUrl = movie.posterPath, modifier = Modifier
            .height(300.dp)
            .fillMaxWidth())

        Text(
            text = movie.originalTitle, style = androidx.compose.ui.text.TextStyle(color = Color.Gray,
                fontWeight = FontWeight.SemiBold, fontSize = 20.sp
            ),
            modifier = Modifier.padding(12.dp)
        )
        Spacer(modifier=Modifier.height(12.dp))

    }
}