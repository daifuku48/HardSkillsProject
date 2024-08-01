package com.natifedanilharitonov.hardskillsproject.presentation.info

import com.natifeuaandroid.domainmodule.features.info.InfoState

data class InfoUiState(
    val email: String? = "",
)

fun InfoState.toUi(): InfoUiState {
    return InfoUiState(
        email = email
    )
}