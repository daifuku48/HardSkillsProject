package com.natifedanilharitonov.domain.use_cases.main_first

import com.natifedanilharitonov.core.UiState
import com.natifedanilharitonov.domain.use_cases.main.StateText

data class MainFirstState(
    val text: StateText = StateText.Pending
) : UiState