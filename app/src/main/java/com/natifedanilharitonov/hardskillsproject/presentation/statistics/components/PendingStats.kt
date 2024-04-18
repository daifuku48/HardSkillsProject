package com.natifedanilharitonov.hardskillsproject.presentation.statistics.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.natifedanilharitonov.hardskillsproject.utils.TestTags.PENDING_TAG

@Composable
fun PendingStats() {
    Box(
        modifier =
            Modifier
                .fillMaxWidth()
                .testTag(PENDING_TAG)
                .height(400.dp),
        contentAlignment = Alignment.Center,
    ) {
        CircularProgressIndicator()
    }
}
