package com.natifedanilharitonov.hardskillsproject.presentation.base.screens

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.natifedanilharitonov.hardskillsproject.presentation.base.navigation.ProjectScreens

class Screens(private val projectsScreens: List<Screen>) : ProjectScreens {
    override fun show(
        navGraphBuilder: NavGraphBuilder,
        showBottomState: (Boolean) -> Unit,
        showDrawerState: (Boolean) -> Unit
    ) {
        for (screen in projectsScreens) {
            screen.show(
                navGraphBuilder,
                showBottomState = { state ->
                    showBottomState(state)
                },
                showDrawerState = { state ->
                    showDrawerState(state)
                }
            )
        }
    }
}