package com.natifedanilharitonov.hardskillsproject.presentation.base.screens

import androidx.navigation.NavGraphBuilder
import com.natifedanilharitonov.hardskillsproject.presentation.base.navigation.ProjectScreens

class Screens(private val projectsScreens: List<Screen>) : ProjectScreens {
    override fun show(navGraphBuilder: NavGraphBuilder) {
        for (screen in projectsScreens) {
            screen.show(navGraphBuilder)
        }
    }
}