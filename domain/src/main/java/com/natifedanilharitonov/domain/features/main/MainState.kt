package com.natifedanilharitonov.domain.features.main

import com.natifedanilharitonov.core.UiState

data class MainState(
    val text: StateText = StateText.Pending
) : UiState