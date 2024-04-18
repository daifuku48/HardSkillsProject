package com.natifedanilharitonov.hardskillsproject.presentation.randomAnimeImage.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AnimeScreenButton(
    text: String,
    onClick: () -> Unit,
) {
    Button(onClick = onClick, modifier = Modifier.padding(bottom = 40.dp)) {
        Text(text = text)
    }
}
