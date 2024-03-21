package com.natifedanilharitonov.hardskillsproject.presentation.main_second

import com.natifedanilharitonov.hardskillsproject.core.UiEvent
import com.natifedanilharitonov.hardskillsproject.presentation.main.components.StateText

sealed class MainSecondEvent : UiEvent {
    data object GetMainTextEvent : MainSecondEvent()
    data class MainTextIsReceived(val text: StateText) : MainSecondEvent()
    data object ErrorEvent : MainSecondEvent()
}