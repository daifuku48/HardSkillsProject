package com.natifedanilharitonov.hardskillsproject.presentation.infoSecond

import com.natifeuaandroid.domainmodule.features.infoSecond.InfoSecondState

class InfoSecondUiState(
    val text: String?,
)

fun InfoSecondState.toUi(): InfoSecondUiState {
    return InfoSecondUiState(text = text)
}

