package com.natifeuaandroid.domainmodule.features.infoFirst

sealed class InfoFirstEvent {
    data object GetTextEvent : InfoFirstEvent()

    data class TextReceivedEvent(val text: String?) : InfoFirstEvent()

    data object ErrorEvent : InfoFirstEvent()
}
