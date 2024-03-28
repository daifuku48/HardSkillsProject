package com.natifedanilharitonov.hardskillsproject.presentation.activities

import com.natifedanilharitonov.hardskillsproject.core.UiState

data class MainActivityState(
    val bottomState: Boolean = false,
    val drawerState: Boolean = false,
    val startDestination: String? = null,
    val bottomNavigationSelectedItem: Int = 0
) : UiState