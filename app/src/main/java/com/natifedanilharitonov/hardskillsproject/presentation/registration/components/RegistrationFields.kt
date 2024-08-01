package com.natifedanilharitonov.hardskillsproject.presentation.registration.components

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
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.natifedanilharitonov.hardskillsproject.R
import com.natifedanilharitonov.hardskillsproject.presentation.baseComponentsKit.BaseButton
import com.natifedanilharitonov.hardskillsproject.presentation.login.components.AuthTextField
import com.natifedanilharitonov.hardskillsproject.presentation.login.components.AuthTextTitle
import com.natifedanilharitonov.hardskillsproject.presentation.login.components.PasswordTextField
import com.natifedanilharitonov.hardskillsproject.utils.TestTags.EMAIL_TAG
import com.natifedanilharitonov.hardskillsproject.utils.TestTags.PASSWORD_TAG

@Composable
fun RegistrationFields(
    email: String,
    emailChanged: (String) -> Unit,
    password: String,
    passwordChanged: (String) -> Unit,
    registerClick: () -> Unit,
    loginClick: () -> Unit,
    registerButtonEnabled: Boolean,
    emailLabel: Boolean,
    passwordLabel: Boolean,
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Box(
            modifier =
            Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp)
                .background(
                    color = colorResource(id = R.color.authCardBackground),
                    shape = RoundedCornerShape(20.dp),
                )
                .border(
                    width = 1.dp,
                    color = colorResource(id = R.color.authBorderCard),
                    shape = RoundedCornerShape(20.dp),
                ),
            contentAlignment = Alignment.Center,
        ) {
            Column {
                AuthTextTitle(
                    text = stringResource(R.string.registration),
                    modifier = Modifier.padding(30.dp),
                )

                AuthTextField(
                    modifier =
                    Modifier
                        .fillMaxWidth()
                        .testTag(EMAIL_TAG)
                        .padding(start = 10.dp, end = 10.dp),
                    text = email,
                    onTextChanged = { email -> emailChanged(email) },
                    labelText = if (emailLabel) stringResource(id = R.string.email_label) else stringResource(
                        id = R.string.email_error_label
                    ),
                    colorLabelText = if (emailLabel) colorResource(id = R.color.black) else colorResource(
                        id = R.color.red
                    ),
                )

                Spacer(modifier = Modifier.padding(10.dp))

                PasswordTextField(
                    modifier =
                    Modifier
                        .fillMaxWidth()
                        .testTag(PASSWORD_TAG)
                        .padding(start = 10.dp, end = 10.dp, bottom = 30.dp),
                    text = password,
                    onTextChanged = { password -> passwordChanged(password) },
                    labelText = if (passwordLabel) stringResource(id = R.string.password_label) else stringResource(
                        id = R.string.password_error_label
                    ),
                    colorLabelText = if (passwordLabel) colorResource(id = R.color.black) else colorResource(
                        id = R.color.red
                    ),
                )

                BaseButton(
                    modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    onClick = registerClick,
                    enabled = registerButtonEnabled,
                    text = stringResource(R.string.register_btn),
                    containerColor = Color.DarkGray,
                    textColor = Color.White,
                )

                BaseButton(
                    modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    onClick = loginClick,
                    text = stringResource(R.string.login_btn),
                    containerColor = Color.Black,
                    textColor = Color.White,
                )
            }
        }
    }
}
