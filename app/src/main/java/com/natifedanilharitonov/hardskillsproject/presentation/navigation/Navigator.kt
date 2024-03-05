package com.natifedanilharitonov.hardskillsproject.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavOptions

interface Navigator {
    fun navigate(route: String, navOptions: NavOptions? = null)
    fun popBack()
    fun attach(navController: NavController)
    fun detach()
}