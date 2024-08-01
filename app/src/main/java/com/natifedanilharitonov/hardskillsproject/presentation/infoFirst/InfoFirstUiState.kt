package com.natifedanilharitonov.hardskillsproject.presentation.infoFirst

import com.natifeuaandroid.domainmodule.features.infoFirst.InfoFirstState

data class InfoFirstUiState(val text: String?)

fun InfoFirstState.toUi(): InfoFirstUiState {
    return InfoFirstUiState(text = text)
}