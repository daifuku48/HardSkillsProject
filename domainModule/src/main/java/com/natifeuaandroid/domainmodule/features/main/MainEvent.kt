package com.natifeuaandroid.domainmodule.features.main

sealed class MainEvent {
    data object GetMainTextEvent : MainEvent()

    data class MainTextIsReceived(val text: String?) : MainEvent()

    data object ErrorEvent : MainEvent()
}
