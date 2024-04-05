package com.natifedanilharitonov.domain.features.infoFirst

import com.natifedanilharitonov.core.UiState
import com.natifedanilharitonov.domain.features.main.StateText

data class InfoFirstState(
    val text: StateText = StateText.Pending,
) : UiState
