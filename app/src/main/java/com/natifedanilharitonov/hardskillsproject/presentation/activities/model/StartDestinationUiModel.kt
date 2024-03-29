package com.natifedanilharitonov.hardskillsproject.presentation.activities.model

import com.natifedanilharitonov.hardskillsproject.presentation.base.screens.Screen

interface StartDestinationUiModel {
    data object MainScreenDestination : StartDestinationUiModel
    data object LoginScreenDestination : StartDestinationUiModel
}

fun StartDestinationUiModel.getDestination(): String {
    return when (this) {
        is StartDestinationUiModel.LoginScreenDestination -> Screen.LoginScreen.route
        is StartDestinationUiModel.MainScreenDestination -> Screen.MainScreen.route
        else -> {
            ""
        }
    }
}