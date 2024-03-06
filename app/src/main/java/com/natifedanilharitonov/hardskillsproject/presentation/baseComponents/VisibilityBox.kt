package com.natifedanilharitonov.hardskillsproject.presentation.baseComponents

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout

@Composable
fun VisibilityBox(
    visibility: Boolean,
    modifier: Modifier,
    content: @Composable () -> Unit
) {
    if (visibility) {
        Layout(
            content = content,
            measurePolicy = { _, constraints ->
                layout(constraints.minWidth, constraints.minHeight) {}
            },
            modifier = modifier
        )
    }
}