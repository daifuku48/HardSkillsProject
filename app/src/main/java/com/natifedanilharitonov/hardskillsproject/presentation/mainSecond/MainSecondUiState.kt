package com.natifedanilharitonov.hardskillsproject.presentation.mainSecond

import com.natifeuaandroid.domainmodule.features.mainSecond.MainSecondState

data class MainSecondUiState(
    val text: String?,
)

fun MainSecondState.toUi(): MainSecondUiState {
    return MainSecondUiState(text = text)
}