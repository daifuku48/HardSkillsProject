package com.natifedanilharitonov.hardskillsproject.presentation.base.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController

interface ProjectScreens {
    fun show(
        navGraphBuilder: NavGraphBuilder,
        showBottomState: (Boolean) -> Unit,
    )
}