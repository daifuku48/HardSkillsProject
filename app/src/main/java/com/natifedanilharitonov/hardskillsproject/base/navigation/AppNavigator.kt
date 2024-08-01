package com.natifedanilharitonov.hardskillsproject.base.navigation

import androidx.navigation.NavController
import androidx.navigation.NavOptions

class AppNavigator : Navigator {
    private var navController: NavController? = null

    override fun navigate(
        route: String,
        navOptions: NavOptions?,
    ) {
        navController?.navigate(route, navOptions)
    }

    override fun popBackStack(
        destination: String,
        inclusive: Boolean,
    ) {
        navController?.popBackStack(destination, inclusive)
    }

    override fun popBack() {
        val currentBackStackEntry = navController?.currentBackStackEntry
        if (currentBackStackEntry != null) {
            navController?.popBackStack(currentBackStackEntry.destination.id, true)
        }
    }

    override fun attach(navController: NavController) {
        this.navController = navController
    }

    override fun detach() {
        navController = null
    }
}
