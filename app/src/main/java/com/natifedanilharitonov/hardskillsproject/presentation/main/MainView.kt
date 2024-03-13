package com.natifedanilharitonov.hardskillsproject.presentation.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.natifedanilharitonov.hardskillsproject.R
import org.koin.androidx.compose.koinViewModel

@Composable
fun MainView(viewModel: MainViewModel = koinViewModel()) {
    val state by viewModel.state.collectAsState()

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column {
            Text(text = stringResource(R.string.main_screen))
            Button(onClick = viewModel::navigateToNextScreen) {
                Text(text = "Next Screen")
            }
        }
    }
}