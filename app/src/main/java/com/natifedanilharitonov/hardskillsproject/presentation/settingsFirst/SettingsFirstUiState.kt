package com.natifedanilharitonov.hardskillsproject.presentation.settingsFirst

import com.natifeuaandroid.domainmodule.features.settingsFirst.SettingsFirstState

data class SettingsFirstUiState(
    val text: String?,
)

fun SettingsFirstState.toUi(): SettingsFirstUiState {
    return SettingsFirstUiState(
        text = text
    )
}
