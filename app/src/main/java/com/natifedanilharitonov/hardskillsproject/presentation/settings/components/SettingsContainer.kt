package com.natifedanilharitonov.hardskillsproject.presentation.settings.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.natifedanilharitonov.hardskillsproject.R

@Composable
fun SettingsContainer(
    modifier: Modifier = Modifier,
    signOut: () -> Unit,
    navigateToNextScreen: () -> Unit
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = signOut) {
            Text(text = stringResource(R.string.sign_out), fontSize = 24.sp)
        }

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .padding(30.dp)
        )

        Button(onClick = navigateToNextScreen) {
            Text(text = stringResource(id = R.string.next_screen), fontSize = 24.sp)
        }
    }
}