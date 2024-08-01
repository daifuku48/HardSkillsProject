package com.natifedanilharitonov.hardskillsproject.presentation.mainFirst

import com.natifeuaandroid.domainmodule.features.mainFirst.MainFirstState

data class MainFirstUiState(
    val text: String? = "",
)

fun MainFirstState.toUi(): MainFirstUiState {
    return MainFirstUiState(text = text)
}