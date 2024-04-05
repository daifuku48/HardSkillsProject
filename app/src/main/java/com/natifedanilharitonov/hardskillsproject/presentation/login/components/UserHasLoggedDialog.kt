package com.natifedanilharitonov.hardskillsproject.presentation.login.components

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.natifedanilharitonov.hardskillsproject.R
import com.natifedanilharitonov.hardskillsproject.presentation.baseComponents.BasePopUpUserDialog

@Composable
fun UserHasLoggedDialog(
    state: Boolean,
    onConfirm: () -> Unit,
) {
    BasePopUpUserDialog(
        modifier = Modifier.padding(30.dp),
        state = state,
        text = stringResource(R.string.user_has_logged),
        buttonText = stringResource(id = R.string.ok),
        onConfirm = onConfirm,
    )
}
