package com.natifedanilharitonov.hardskillsproject.presentation.login.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.natifedanilharitonov.hardskillsproject.R
import com.natifedanilharitonov.hardskillsproject.presentation.login.LoginView

@Composable
fun LoginContainer(
    email: String,
    emailChanged: (String) -> Unit,
    password: String,
    passwordChanged: (String) -> Unit,
    registerClick: () -> Unit,
    loginClick: () -> Unit,
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp)
                .background(
                    color = colorResource(id = R.color.authCardBackground),
                    shape = RoundedCornerShape(20.dp)
                )
                .border(
                    width = 1.dp,
                    color = colorResource(id = R.color.authBorderCard),
                    shape = RoundedCornerShape(20.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Column {
                AuthTextTitle(text = stringResource(R.string.login), modifier = Modifier.padding(30.dp))

            }
        }
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun LoginContainerPreview() {
    LoginView()
}