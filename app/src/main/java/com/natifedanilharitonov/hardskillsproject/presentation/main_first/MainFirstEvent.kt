package com.natifedanilharitonov.hardskillsproject.presentation.main_first

import com.natifedanilharitonov.hardskillsproject.core.UiEvent
import com.natifedanilharitonov.hardskillsproject.presentation.main.components.StateText

sealed class MainFirstEvent : UiEvent {
    data object GetMainTextEvent : MainFirstEvent()
    data class MainTextIsReceived(val text: StateText) : MainFirstEvent()
    data object ErrorEvent : MainFirstEvent()
}