package com.natifedanilharitonov.hardskillsproject.presentation.base.navigation

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
        navController?.popBackStack()
    }

    override fun attach(navController: NavController) {
        this.navController = navController
    }

    override fun detach() {
        navController = null
    }
}
