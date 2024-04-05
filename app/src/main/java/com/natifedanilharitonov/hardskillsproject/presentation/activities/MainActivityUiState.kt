package com.natifedanilharitonov.hardskillsproject.presentation.activities

import com.natifedanilharitonov.core.UiModel
import com.natifedanilharitonov.hardskillsproject.presentation.activities.model.StartDestinationUiModel

data class MainActivityUiState(
    val bottomState: Boolean = false,
    val drawerState: Boolean = false,
    val startDestination: StartDestinationUiModel? = null,
    val bottomNavigationSelectedItem: Int = 0,
) : UiModel
