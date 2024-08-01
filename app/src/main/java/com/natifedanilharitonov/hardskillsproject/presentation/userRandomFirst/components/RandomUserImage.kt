package com.natifedanilharitonov.hardskillsproject.presentation.userRandomFirst.components

import android.graphics.Bitmap
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun RandomUserImage(
    modifier: Modifier = Modifier,
    image: String,
) {
    Box(
        modifier =
            Modifier
                .fillMaxWidth()
                .padding(10.dp),
        contentAlignment = Alignment.Center,
    ) {
        AsyncImage(
            model = image,
            contentDescription = null,
            modifier =
                modifier
                    .size(200.dp)
                    .clip(CircleShape),
            contentScale = ContentScale.Crop,
        )
    }
}
