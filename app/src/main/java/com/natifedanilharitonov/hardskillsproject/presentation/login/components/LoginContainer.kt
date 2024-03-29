package com.natifedanilharitonov.hardskillsproject.presentation.login.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.natifedanilharitonov.hardskillsproject.R
import com.natifedanilharitonov.hardskillsproject.presentation.baseComponents.BaseButton
import com.natifedanilharitonov.hardskillsproject.presentation.login.LoginView
import com.natifedanilharitonov.hardskillsproject.presentation.login.model.EmailLabelState
import com.natifedanilharitonov.hardskillsproject.presentation.login.model.PasswordLabelState

@Composable
fun LoginContainer(
    email: String,
    emailChanged: (String) -> Unit,
    password: String,
    passwordChanged: (String) -> Unit,
    registerClick: () -> Unit,
    loginClick: () -> Unit,
    loginButtonEnabled: Boolean,
    emailLabel: EmailLabelState,
    passwordLabel: PasswordLabelState
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
                AuthTextTitle(
                    text = stringResource(R.string.login),
                    modifier = Modifier.padding(30.dp)
                )

                AuthTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, end = 10.dp),
                    text = email,
                    onTextChanged = { email -> emailChanged(email) },
                    labelText = emailLabel.getLabel(),
                    colorLabelText = emailLabel.getColor()
                )

                Spacer(modifier = Modifier.padding(10.dp))

                AuthTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, end = 10.dp, bottom = 30.dp),
                    text = password,
                    onTextChanged = { password -> passwordChanged(password) },
                    labelText = passwordLabel.getLabel(),
                    colorLabelText = passwordLabel.getColor()
                )

                BaseButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    enabled = loginButtonEnabled,
                    onClick = loginClick,
                    text = stringResource(R.string.login_btn),
                    containerColor = Color.Black,
                    textColor = Color.White
                )

                BaseButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    onClick = registerClick,
                    text = stringResource(R.string.register_btn),
                    containerColor = Color.DarkGray,
                    textColor = Color.White
                )
            }
        }
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun LoginContainerPreview() {
    LoginView()
}