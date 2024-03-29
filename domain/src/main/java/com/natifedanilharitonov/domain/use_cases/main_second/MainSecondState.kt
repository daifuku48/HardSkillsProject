package com.natifedanilharitonov.domain.use_cases.main_second

import com.natifedanilharitonov.core.UiState
import com.natifedanilharitonov.domain.use_cases.main.StateText

data class MainSecondState(
    val text: StateText = StateText.Pending
) : UiState