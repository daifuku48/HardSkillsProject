package com.natifedanilharitonov.hardskillsproject.presentation.activities.model

import androidx.compose.runtime.Stable
import com.natifedanilharitonov.hardskillsproject.presentation.base.screens.Screen

@Stable
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