package com.natifedanilharitonov.domain.features.info_second

import com.natifedanilharitonov.core.UiState
import com.natifedanilharitonov.domain.features.main.StateText

data class InfoSecondState(val text: StateText = StateText.Pending) : UiState