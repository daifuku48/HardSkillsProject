package com.natifedanilharitonov.hardskillsproject.base.navigation

import androidx.navigation.NavController
import androidx.navigation.NavOptions

interface Navigator {
    fun navigate(
        route: String,
        navOptions: NavOptions? = null,
    )

    fun popBackStack(
        destination: String,
        inclusive: Boolean,
    )

    fun popBack()

    fun attach(navController: NavController)

    fun detach()
}
