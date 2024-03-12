package com.natifedanilharitonov.hardskillsproject.presentation.base.screens

import androidx.navigation.NavGraphBuilder
import com.natifedanilharitonov.hardskillsproject.presentation.base.navigation.ProjectScreens

class Screens(private val projectsScreens: List<Screen>) : ProjectScreens {
    override fun show(navGraphBuilder: NavGraphBuilder, changeBottomState: (Boolean) -> Unit) {
        for (screen in projectsScreens) {
            screen.show(navGraphBuilder, changeBottomState)
        }
    }
}