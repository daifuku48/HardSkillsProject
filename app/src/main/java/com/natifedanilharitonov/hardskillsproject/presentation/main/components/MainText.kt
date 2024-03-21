package com.natifedanilharitonov.hardskillsproject.presentation.main.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.natifedanilharitonov.hardskillsproject.R

@Composable
fun MainText(text: StateText) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        when (text) {
            is StateText.ErrorText -> {
                Text(
                    text = stringResource(R.string.network_error),
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            }

            is StateText.Pending -> {
                CircularProgressIndicator()
            }

            is StateText.Text -> {
                Text(text = text.text, modifier = Modifier.padding(30.dp))
            }
        }
    }
}