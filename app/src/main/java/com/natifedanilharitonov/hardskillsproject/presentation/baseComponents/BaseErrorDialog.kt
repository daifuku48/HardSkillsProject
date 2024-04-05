package com.natifedanilharitonov.hardskillsproject.presentation.baseComponents

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.natifedanilharitonov.hardskillsproject.R

@Composable
fun BaseErrorDialog(
    state: Boolean,
    onConfirm: () -> Unit,
) {
    BasePopUpUserDialog(
        state = state,
        text = stringResource(R.string.error_dialog),
        buttonText = stringResource(id = R.string.ok),
        onConfirm = onConfirm,
    )
}
