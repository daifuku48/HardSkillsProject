package com.natifedanilharitonov.hardskillsproject.presentation.main

import com.natifedanilharitonov.hardskillsproject.core.UiEvent
import com.natifedanilharitonov.hardskillsproject.presentation.main.components.StateText

sealed class MainEvent : UiEvent {
    data object GetMainTextEvent : MainEvent()
    data class MainTextIsReceived(val text: StateText) : MainEvent()
    data object ErrorEvent : MainEvent()
}
