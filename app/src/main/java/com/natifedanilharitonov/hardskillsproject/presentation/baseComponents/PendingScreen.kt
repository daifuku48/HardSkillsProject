package com.natifedanilharitonov.hardskillsproject.presentation.baseComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun PendingScreen(
    modifier: Modifier,
    state: Boolean
) {
    if (state) {
        Box(
            modifier = modifier.background(Color.White),
            contentAlignment = Alignment.Center
        ) {
            LinearProgressIndicator()
        }
    }
}