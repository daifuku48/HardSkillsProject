package com.natifedanilharitonov.hardskillsproject.presentation.statistics.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.natifedanilharitonov.hardskillsproject.R

@Composable
fun ErrorStatistic() {
    Box(
        modifier =
            Modifier
                .fillMaxWidth()
                .height(400.dp),
        contentAlignment = Alignment.Center,
    ) {
        Text(text = stringResource(R.string.error_stats_model))
    }
}
