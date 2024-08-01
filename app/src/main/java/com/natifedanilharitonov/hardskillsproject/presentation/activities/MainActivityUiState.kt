package com.natifedanilharitonov.hardskillsproject.presentation.activities

import com.natifeuaandroid.domainmodule.features.mainActivity.MainActivityState


data class MainActivityUiState(
    val bottomState: Boolean = false,
    val drawerState: Boolean = false,
    val startDestination: String? = null,
    val bottomNavigationSelectedItem: Int = 0,
)

fun MainActivityState.toUi(): MainActivityUiState =
    MainActivityUiState(
        bottomState = bottomState,
        drawerState = drawerState,
        startDestination = startDestination,
        bottomNavigationSelectedItem = bottomNavigationSelectedItem,
    )
