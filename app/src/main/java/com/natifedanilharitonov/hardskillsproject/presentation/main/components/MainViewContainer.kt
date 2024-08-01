package com.natifedanilharitonov.hardskillsproject.presentation.main.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.natifedanilharitonov.hardskillsproject.ui.theme.HardSkillsProjectTheme

@Composable
fun MainViewContainer(
    title: String,
    text: String?,
    navigate: () -> Unit,
    buttonText: String,
) {
    PageTitle(text = title)

    MainText(text = text)

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
        MainButton(
            text = buttonText,
            onClick = navigate,
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewMainView() {
    HardSkillsProjectTheme {
        MainViewContainer(
            title = "Title",
            text = "text text text text text text text text ",
            navigate = { },
            buttonText = "navigate",
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewMainErrorView() {
    HardSkillsProjectTheme {
        MainViewContainer(
            title = "Title",
            text = ERROR_TEXT,
            navigate = { },
            buttonText = "navigate",
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewMainPendingView() {
    HardSkillsProjectTheme {
        MainViewContainer(
            title = "Title",
            text = PENDING_TEXT,
            navigate = { },
            buttonText = "navigate",
        )
    }
}

const val PENDING_TEXT = ""
val ERROR_TEXT = null