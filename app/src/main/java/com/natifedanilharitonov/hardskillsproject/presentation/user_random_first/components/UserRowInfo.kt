package com.natifedanilharitonov.hardskillsproject.presentation.user_random_first.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.natifedanilharitonov.hardskillsproject.R
import com.natifedanilharitonov.hardskillsproject.presentation.baseComponents.TableCell

@Composable
fun UserRowInfo(title: String, description: String) {
    Row(
        modifier = Modifier
            .background(colorResource(id = R.color.authBorderCard))
            .border(1.dp, Color.Black)
    ) {
        TableCell(title, weight = 0.5f)
        TableCell(text = description, weight = 1f)
    }
}