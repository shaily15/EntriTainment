package com.shaily.entritainment.presentation.navigation

sealed class TopLevelDestination(
    val route: String
) {
    object Home : TopLevelDestination(
        route = "home"
    )

    object Detail : TopLevelDestination(
        route = "detail"
    )

    /**
     * Use this function to pass arguments to navigation destination
     */
    fun withArgs(vararg args: Any): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}