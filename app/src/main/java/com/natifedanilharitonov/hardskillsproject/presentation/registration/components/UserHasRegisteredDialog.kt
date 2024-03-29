package com.natifedanilharitonov.hardskillsproject.presentation.registration.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.natifedanilharitonov.hardskillsproject.R
import com.natifedanilharitonov.hardskillsproject.presentation.baseComponents.BasePopUpUserDialog

@Composable
fun UserHasRegisteredDialog(
    state: Boolean,
    onConfirm: () -> Unit
) {
    BasePopUpUserDialog(
        state = state,
        text = "Користувач зареєстрований",
        buttonText = stringResource(id = R.string.ok),
        onConfirm = onConfirm
    )
}