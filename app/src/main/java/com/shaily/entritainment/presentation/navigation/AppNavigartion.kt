package com.shaily.entritainment.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.shaily.entritainment.presentation.screens.HomeScreen

@Composable
fun AppNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = TopLevelDestination.Home.route
    ) {
        composable(route = TopLevelDestination.Home.route) {

            HomeScreen()
        }

        composable(
            route = TopLevelDestination.Detail.route + "/{imageIcon}"+ "/{title}"+ "/{popularity}"
                    + "/{releaseDate}",
            arguments = listOf(
                navArgument("imageIcon") {
                    type = NavType.StringType
                }
            )
        ) {
//                backStackEntry ->
//            val number = backStackEntry.arguments?.getInt("number") ?: return@composable
//            DetailsScreen(onBackClick = { navController.popBackStack() }, number = number)
        }
    }
}