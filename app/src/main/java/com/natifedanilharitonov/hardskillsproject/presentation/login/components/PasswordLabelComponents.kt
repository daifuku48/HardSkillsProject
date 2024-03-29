package com.natifedanilharitonov.hardskillsproject.presentation.login.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import com.natifedanilharitonov.hardskillsproject.R
import com.natifedanilharitonov.hardskillsproject.presentation.login.model.PasswordLabelState

@Composable
fun PasswordLabelState.getLabel(): String {
    return when (this) {
        is PasswordLabelState.ValidPassword -> stringResource(id = R.string.email_label)
        is PasswordLabelState.ErrorPassword -> stringResource(id = R.string.email_error_label)
        else -> {
            ""
        }
    }
}

@Composable
fun PasswordLabelState.getColor(): Color {
    return when (this) {
        is PasswordLabelState.ValidPassword -> {
            colorResource(id = R.color.black)
        }

        is PasswordLabelState.ErrorPassword -> {
            colorResource(id = R.color.red)
        }

        else -> {
            Color.Black
        }
    }
}