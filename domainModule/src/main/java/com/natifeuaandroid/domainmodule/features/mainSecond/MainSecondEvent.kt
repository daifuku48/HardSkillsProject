package com.natifeuaandroid.domainmodule.features.mainSecond

sealed class MainSecondEvent {
    data object GetMainTextEvent : MainSecondEvent()

    data class MainTextIsReceived(val text: String?) : MainSecondEvent()

    data object ErrorEvent : MainSecondEvent()
}
