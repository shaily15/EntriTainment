package com.shaily.entritainment.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter

@Composable
fun MovieImage(
    imageUrl: String,
    modifier: Modifier = Modifier
) {
    HomeLayout(
        color = Color.LightGray,
        elevation = 4.dp,
        shape = RectangleShape,
        modifier = modifier
    ) {
        Image(
            painter = rememberImagePainter(imageUrl),
            contentDescription = "gfg image",
            modifier = Modifier
                .height(300.dp)
                .width(200.dp),
            contentScale = ContentScale.Fit
        )
    }
}

