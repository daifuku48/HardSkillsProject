package com.natifedanilharitonov.hardskillsproject.presentation.login.components

import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AuthTextField(
    modifier: Modifier = Modifier,
    text: String,
    onTextChanged: (String) -> Unit,
    labelText: String
) {
    TextField(
        modifier = modifier,
        value = text,
        onValueChange = { value -> onTextChanged(value) },
        label = {
            Text(
                text = labelText
            )
        }
    )
}