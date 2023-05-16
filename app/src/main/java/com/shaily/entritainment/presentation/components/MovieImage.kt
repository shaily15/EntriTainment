package com.shaily.entritainment.presentation.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.node.Ref
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.shaily.entritainment.BuildConfig


@Composable
fun MovieImage(
    imageUrl: String,
    modifier: Modifier = Modifier
) {
    HomeLayout(
        color = Color.LightGray,
        elevation = 0.dp,
        shape = RectangleShape,
        modifier = modifier
    ) {
        Log.d("imageUrl", imageUrl)
        Image(
            // on below line we are adding the image url
            // from which we will  be loading our image.

            painter = rememberImagePainter(imageUrl),
            // on below line we are adding content
            // description for our image.
            contentDescription = "gfg image",

            // on below line we are adding modifier for our
            // image as wrap content for height and width.
            modifier = Modifier
                .height(300.dp)
                .width(300.dp)
        )
    }
}

