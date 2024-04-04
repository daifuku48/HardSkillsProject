package com.natifedanilharitonov.domain.features.main_second

import com.natifedanilharitonov.core.UiState
import com.natifedanilharitonov.domain.features.main.StateText

data class MainSecondState(
    val text: StateText = StateText.Pending
) : UiState