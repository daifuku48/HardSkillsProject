package com.natifedanilharitonov.domain.use_cases.main

import com.natifedanilharitonov.core.UiState

data class MainState(
    val text: StateText = StateText.Pending
) : UiState