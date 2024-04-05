package com.natifedanilharitonov.domain.features.main

import com.natifedanilharitonov.core.UiEvent

sealed class MainEvent : UiEvent {
    data object GetMainTextEvent : MainEvent()

    data class MainTextIsReceived(val text: StateText) : MainEvent()

    data object ErrorEvent : MainEvent()
}
