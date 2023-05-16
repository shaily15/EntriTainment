package com.shaily.entritainment.presentation.navigation

import androidx.activity.compose.BackHandler
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material.BottomSheetScaffoldState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.Lifecycle
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.shaily.entritainment.presentation.components.MovieDetail
import com.shaily.entritainment.presentation.navigation.Destinations.MOVIE_ID_KEY
import com.shaily.entritainment.presentation.screens.HomeScreen
import kotlinx.coroutines.CoroutineScope

object Destinations {
    const val MOVIE_HOME_ROUTE = "movie_home_screen"
    const val MOVIE_DETAIL_ROUTE = "movie_detail_screen"
    const val LOGIN_ROUTE = "login_screen"
    const val SIGN_UP_ROUTE = "sign_up_screen"
    const val MOVIE_ID_KEY = "movieId"
}

@ExperimentalAnimationApi
@ExperimentalMaterialApi
@Composable
fun NavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = Destinations.MOVIE_HOME_ROUTE,
    mainNavActions: MainActions
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        navigation(
            route = Destinations.MOVIE_HOME_ROUTE,
            startDestination = Destinations.MOVIE_HOME_ROUTE
        ) {
            composable(Destinations.MOVIE_HOME_ROUTE) {
                HomeScreen()
            }
        }
        composable(
            route = "${Destinations.MOVIE_DETAIL_ROUTE}/{$MOVIE_ID_KEY}",
            arguments = listOf(navArgument(MOVIE_ID_KEY) { type = NavType.LongType })
        ) { from: NavBackStackEntry ->

            BackHandler {
                mainNavActions.upPress(from)
            }

            val arguments = requireNotNull(from.arguments)
            val movieId = arguments.getLong(MOVIE_ID_KEY)

            MovieDetail(
                movieId = movieId,
                upPress = {
                    mainNavActions.upPress(from)
                }
            )
        }
    }
}

class MainActions(
    navController: NavHostController,
    updateAppBarVisibility: (Boolean) -> Unit
) {
    val openMovieDetails = { movieId: Long ->
        updateAppBarVisibility(false)
        navController.navigate("${Destinations.MOVIE_DETAIL_ROUTE}/$movieId") {
            // Pop up to the start destination of the graph to avoid building up a large
            // stack of destinations on the back stack as users select items
            popUpTo(navController.graph.startDestinationId)
            // Avoid multiple copies of the same destination when re-selecting the same item
            launchSingleTop = true
        }
    }
    val upPress: (rom: NavBackStackEntry) -> Unit = { from: NavBackStackEntry ->
        // In order to discard duplicated navigation events, we check the Lifecycle
        if (from.lifecycleIsResumed()) {
            updateAppBarVisibility(true)
            navController.navigateUp()
        }
    }
}

/**
 * If the lifecycle is not resumed it means this NavBackStackEntry already processed a nav event.
 *
 * This is used to de-duplicate navigation events.
 */
fun NavBackStackEntry.lifecycleIsResumed() = this.lifecycle.currentState == Lifecycle.State.RESUMED