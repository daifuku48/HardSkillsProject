package com.natifeuaandroid.domainmodule.features.mainFirst

sealed class MainFirstEvent {
    data object GetMainTextEvent : MainFirstEvent()

    data class MainTextIsReceived(val text: String?) : MainFirstEvent()

    data object ErrorEvent : MainFirstEvent()
}
