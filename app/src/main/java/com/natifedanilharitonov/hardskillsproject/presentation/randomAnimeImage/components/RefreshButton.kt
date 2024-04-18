package com.natifedanilharitonov.hardskillsproject.presentation.randomAnimeImage.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.vectorResource
import com.natifedanilharitonov.hardskillsproject.R
import com.natifedanilharitonov.hardskillsproject.utils.TestTags.REFRESH_BUTTON_TAG

@Composable
fun RefreshButton(onClick: () -> Unit) {
    Box(modifier = Modifier.fillMaxWidth().testTag(REFRESH_BUTTON_TAG), contentAlignment = Alignment.Center) {
        IconButton(onClick = onClick) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.refresh),
                contentDescription = "Refresh",
            )
        }
    }
}
