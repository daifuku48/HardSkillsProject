package com.natifedanilharitonov.hardskillsproject.base.navigation

import androidx.navigation.NavGraphBuilder

interface ProjectScreens {
    fun show(
        navGraphBuilder: NavGraphBuilder,
        showBottomState: (Boolean) -> Unit,
        showDrawerState: (Boolean) -> Unit,
    )

    class ProjectScreensImpl(
        private val projectsScreens: List<Screen>,
    ) : ProjectScreens {
        override fun show(
            navGraphBuilder: NavGraphBuilder,
            showBottomState: (Boolean) -> Unit,
            showDrawerState: (Boolean) -> Unit,
        ) {
            for (screen in projectsScreens) {
                screen.show(
                    navGraphBuilder,
                    showBottomState = { state ->
                        showBottomState(state)
                    },
                    showDrawerState = { state ->
                        showDrawerState(state)
                    },
                )
            }
        }
    }
}
