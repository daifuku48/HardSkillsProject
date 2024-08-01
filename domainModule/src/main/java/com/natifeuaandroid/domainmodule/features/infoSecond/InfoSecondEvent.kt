package com.natifeuaandroid.domainmodule.features.infoSecond

sealed class InfoSecondEvent  {
    data object GetTextEvent : InfoSecondEvent()

    data class TextReceivedEvent(val text: String?) : InfoSecondEvent()

    data object ErrorEvent : InfoSecondEvent()
}
