package com.natifedanilharitonov.hardskillsproject.presentation.main

import com.natifeuaandroid.domainmodule.features.main.MainState

data class MainUiState(
    val text: String?,
)

fun MainState.toUi(): MainUiState {
    return MainUiState(text = text)
}