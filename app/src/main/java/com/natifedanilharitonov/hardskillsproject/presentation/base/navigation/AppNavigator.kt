package com.natifedanilharitonov.hardskillsproject.presentation.base.navigation

import androidx.navigation.NavController
import androidx.navigation.NavOptions
import com.natifedanilharitonov.hardskillsproject.presentation.navigation.Navigator

class AppNavigator : Navigator {
    private var _navController : NavController? = null
    private val navController : NavController
        get() = requireNotNull(_navController) { "at first you need to attach navController before navigating "}


    override fun navigate(route: String, navOptions: NavOptions?) {
        navController.navigate(route, navOptions)
    }

    override fun popBack() {
        navController.popBackStack()
    }

    override fun attach(navController: NavController) {
        _navController = navController
    }

    override fun detach() {
        _navController = null
    }
}