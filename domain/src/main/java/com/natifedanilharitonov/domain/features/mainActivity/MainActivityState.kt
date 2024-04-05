package com.natifedanilharitonov.domain.features.mainActivity

import com.natifedanilharitonov.core.UiState

data class MainActivityState(
    val bottomState: Boolean = false,
    val drawerState: Boolean = false,
    val startDestination: StartDestinationResult? = null,
    val bottomNavigationSelectedItem: Int = 0,
) : UiState
