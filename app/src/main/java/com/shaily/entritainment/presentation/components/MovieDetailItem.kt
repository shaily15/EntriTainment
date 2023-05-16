package com.shaily.entritainment.presentation.components

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.ThumbUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shaily.entritainment.R
import com.shaily.entritainment.domain.model.Movie
import com.shaily.entritainment.ui.theme.LightGrey2
import com.shaily.entritainment.ui.theme.TextSecondary
import com.shaily.entritainment.ui.theme.TextSecondaryDark
import com.shaily.entritainment.ui.theme.VeryLightGrey

@ExperimentalAnimationApi
@Composable
fun MovieDetail(
    movieId: Long,
    upPress: () -> Unit
) {
    Column {
        MovieDetailAppBar(upPress = upPress)

    }
}

@Composable
private fun MovieDetailLayout(movie: Movie) {
    Row {
        Image(
            painterResource(id = R.drawable.entri_logo),
            contentDescription = "EntriTainment logo",
            modifier = Modifier
                .size(20.dp)
                .clickable { }
        )
        Text(
            text = "FILM",
            fontSize = 13.sp,
            fontWeight = FontWeight.Light,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 4.dp)
                .align(Alignment.CenterVertically),
            letterSpacing = 2.sp
        )
    }
    Spacer(modifier = Modifier.height(10.dp))
    Text(
        text = movie.originalTitle,
        fontSize = 24.sp,
        fontWeight = FontWeight.ExtraBold,
        modifier = Modifier.fillMaxWidth(),
        maxLines = 1
    )
    Spacer(modifier = Modifier.height(10.dp))
    Row {
        Text(
            text = "98% Match",
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xff65b562)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = movie.releaseDate.substring(0, 4),
            fontSize = 12.sp,
            fontWeight = FontWeight.Light,
            color = Color.Black
        )
        Spacer(modifier = Modifier.width(10.dp))
        Box(
            modifier = Modifier
                .background(
                    color = Color.LightGray,
                    shape = RoundedCornerShape(8)
                )
                .padding(start = 4.dp, top = 1.dp, end = 4.dp, bottom = 1.dp)
        ) {
            Text(
                text = "7+",
                fontSize = 10.sp,
                fontWeight = FontWeight.Light,
                color = LightGrey2
            )
        }
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = "1h 25m",
            fontSize = 12.sp,
            fontWeight = FontWeight.Light,
            color = TextSecondaryDark
        )
        Spacer(modifier = Modifier.width(10.dp))
        Box(
            modifier = Modifier
                .background(
                    color = VeryLightGrey,
                    shape = RoundedCornerShape(8)
                )
                .padding(start = 3.dp, top = 0.dp, end = 3.dp, bottom = 0.dp)
        ) {
            Text(
                text = "HD",
                fontSize = 10.sp,
                fontWeight = FontWeight.Light,
                color = Color.Black,
                letterSpacing = 2.sp
            )
        }
    }
    Spacer(modifier = Modifier.height(15.dp))
    Text(
        text = movie.originalTitle,
        fontSize = 13.sp,
        textAlign = TextAlign.Justify,
        fontWeight = FontWeight.Light,
        maxLines = 4,
        lineHeight = 18.sp,
        overflow = TextOverflow.Ellipsis,
        color = TextSecondary
    )
    Spacer(modifier = Modifier.height(8.dp))
    Row {
        Text(
            text = "Average Vote: ",
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.align(Alignment.CenterVertically),
            color = TextSecondaryDark
        )
        Text(
            text = movie.releaseDate,
            fontSize = 12.sp,
            fontWeight = FontWeight.Light,
            modifier = Modifier.align(Alignment.CenterVertically),
            color = TextSecondaryDark
        )
    }
    Spacer(modifier = Modifier.height(20.dp))
}

@ExperimentalAnimationApi
@Composable
fun MovieDetailAppBar(
    modifier: Modifier = Modifier,
    upPress: () -> Unit
) {
    Surface(
        modifier = modifier
            .padding(top = 30.dp)
            .height(50.dp),
        color = Color.Black.copy(alpha = 0.5f)
    ) {
        TopAppBar(
            elevation = 0.dp,
            backgroundColor = Color.Transparent,
            contentColor = Color.Cyan,
            modifier = modifier
                .height(100.dp)
        ) {
            Column {
                AppBar(showBack = true, upPress = upPress)
            }
        }
    }
}

@Composable
fun AppBar(
    showBack: Boolean = false,
    upPress: () -> Unit = {}
) {
    Row(
        modifier = Modifier.padding(start = 10.dp)
    ) {
        Box(
            modifier = Modifier
                .weight(6f)
                .align(Alignment.CenterVertically)
        ) {
            if (showBack) {
                Icon(
                    imageVector = Icons.Outlined.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.LightGray,
                    modifier = Modifier.clickable { upPress() }
                )
            } else {
                Image(
                    painterResource(id = R.drawable.entri_logo),
                    contentDescription = "EntriTainMent logo",
                    modifier = Modifier
                        .size(30.dp)
                        .clickable { }
                )
            }
        }

    }
}