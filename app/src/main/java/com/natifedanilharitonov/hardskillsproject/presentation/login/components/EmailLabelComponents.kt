package com.natifedanilharitonov.hardskillsproject.presentation.login.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import com.natifedanilharitonov.hardskillsproject.R
import com.natifedanilharitonov.hardskillsproject.presentation.login.model.EmailLabelState

@Composable
fun EmailLabelState.getLabel(): String {
    return when (this) {
        is EmailLabelState.ValidEmailLabel -> stringResource(id = R.string.email_label)
        is EmailLabelState.ErrorEmailLabel -> stringResource(id = R.string.email_error_label)
        else -> {
            ""
        }
    }
}

@Composable
fun EmailLabelState.getColor(): Color {
    return when (this) {
        is EmailLabelState.ValidEmailLabel -> {
            colorResource(id = R.color.black)
        }

        is EmailLabelState.ErrorEmailLabel -> {
            colorResource(id = R.color.red)
        }

        else -> {
            Color.Black
        }
    }
}
