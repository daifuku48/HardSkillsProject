package com.natifedanilharitonov.hardskillsproject.presentation.settingsSecond

import com.natifeuaandroid.domainmodule.features.settingsSecond.SettingsSecondState

data class SettingsSecondUiState(
    val text: String?,
)

fun SettingsSecondState.toUi(): SettingsSecondUiState {
    return SettingsSecondUiState(
        text = text
    )
}
