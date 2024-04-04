package com.natifedanilharitonov.domain.features.main_first

import com.natifedanilharitonov.core.UiState
import com.natifedanilharitonov.domain.features.main.StateText

data class MainFirstState(
    val text: StateText = StateText.Pending
) : UiState