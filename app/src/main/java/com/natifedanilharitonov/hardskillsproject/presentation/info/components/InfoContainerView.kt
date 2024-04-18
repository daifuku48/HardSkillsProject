package com.natifedanilharitonov.hardskillsproject.presentation.info.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.natifedanilharitonov.hardskillsproject.R
import com.natifedanilharitonov.hardskillsproject.ui.theme.HardSkillsProjectTheme
import com.natifedanilharitonov.hardskillsproject.utils.TestTags.USER_EMAIL_TAG

@Composable
fun InfoContainerView(
    email: String,
    navigate: () -> Unit,
) {
    Column(
        modifier =
            Modifier
                .fillMaxSize()
                .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(id = R.drawable.users),
            contentDescription = null,
            modifier =
                Modifier
                    .size(120.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primary)
                    .padding(8.dp),
        )

        Text(
            text = stringResource(id = R.string.email, email),
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
            modifier =
                Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .testTag(USER_EMAIL_TAG),
        )

        Button(
            onClick = navigate,
            modifier =
                Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
        ) {
            Text(text = stringResource(R.string.next_screen))
        }
    }
}

@Preview
@Composable
fun PreviewInfo() {
    HardSkillsProjectTheme {
        InfoContainerView(
            email = "mock@gmail.com",
            navigate = {},
        )
    }
}
