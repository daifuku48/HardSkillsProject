package com.natifedanilharitonov.hardskillsproject.presentation.main

import com.natifedanilharitonov.hardskillsproject.core.UiState
import com.natifedanilharitonov.hardskillsproject.presentation.main.components.StateText

data class MainState(
    val text: StateText = StateText.Pending
) : UiState