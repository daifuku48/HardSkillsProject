package com.natifedanilharitonov.hardskillsproject.presentation.baseComponentsKit

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.natifedanilharitonov.hardskillsproject.presentation.main.components.MainButton

@Composable
fun ButtonColumn(
    popBackText: String,
    popBack: () -> Unit,
    navigateNextText: String,
    navigateNext: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom,
    ) {
        MainButton(text = popBackText, onClick = popBack)
        MainButton(text = navigateNextText, onClick = navigateNext)
    }
}
