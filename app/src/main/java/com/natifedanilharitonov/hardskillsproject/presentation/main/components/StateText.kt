package com.natifedanilharitonov.hardskillsproject.presentation.main.components

sealed class StateText {
    data object Pending : StateText()
    data class Text(val text: String) : StateText()
    data object ErrorText : StateText()
}