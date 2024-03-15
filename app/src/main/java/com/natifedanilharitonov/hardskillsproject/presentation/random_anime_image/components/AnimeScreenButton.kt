package com.natifedanilharitonov.hardskillsproject.presentation.random_anime_image.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.natifedanilharitonov.hardskillsproject.R


@Composable
fun AnimeScreenButton(modifier: Modifier = Modifier, onClick: () -> Unit) {
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
        Button(onClick = onClick, modifier = Modifier.padding(bottom = 40.dp)) {
            Text(text = stringResource(id = R.string.next_screen))
        }
    }
}