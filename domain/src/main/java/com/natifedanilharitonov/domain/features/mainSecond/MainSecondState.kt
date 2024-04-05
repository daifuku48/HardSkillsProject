package com.natifedanilharitonov.domain.features.mainSecond

import com.natifedanilharitonov.core.UiState
import com.natifedanilharitonov.domain.features.main.StateText

data class MainSecondState(
    val text: StateText = StateText.Pending,
) : UiState
