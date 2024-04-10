package com.natifedanilharitonov.hardskillsproject.presentation.main.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.natifedanilharitonov.hardskillsproject.presentation.main.model.StateTextUiModel
import com.natifedanilharitonov.hardskillsproject.ui.theme.HardSkillsProjectTheme

@Composable
fun MainViewContainer(
    title: String,
    text: StateTextUiModel,
    navigate: () -> Unit,
    buttonText: String,
) {
    PageTitle(text = title)

    MainText(text = text)

    MainButton(
        text = buttonText,
        onClick = navigate,
    )
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewMainView() {
    HardSkillsProjectTheme {
        MainViewContainer(
            title = "Title",
            text = StateTextUiModel.Text("text text text text text text text text "),
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
            text = StateTextUiModel.ErrorText,
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
            text = StateTextUiModel.Pending,
            navigate = { },
            buttonText = "navigate",
        )
    }
}
