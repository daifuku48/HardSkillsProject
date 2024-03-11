package com.natifedanilharitonov.hardskillsproject.presentation.baseComponents

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun BaseButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String,
    enabled: Boolean = true,
    containerColor: Color,
    textColor: Color
) {
    Button(
        modifier = modifier,
        enabled = enabled,
        onClick = onClick,
        content = {
            Text(text = text, fontSize = 20.sp, color = textColor)
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor
        )
    )
}