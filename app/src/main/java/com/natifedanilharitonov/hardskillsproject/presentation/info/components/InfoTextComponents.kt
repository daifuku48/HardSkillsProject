package com.natifedanilharitonov.hardskillsproject.presentation.info.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.natifedanilharitonov.hardskillsproject.R
import com.natifedanilharitonov.hardskillsproject.presentation.info.model.InfoEmailUiState

@Composable
fun InfoEmailUiState.getText(): String {
    return when (this) {
        is InfoEmailUiState.Pending -> ""
        is InfoEmailUiState.Email -> this.email
        is InfoEmailUiState.Error -> stringResource(id = R.string.unauthorized_user)
        else -> {
            ""
        }
    }
}
