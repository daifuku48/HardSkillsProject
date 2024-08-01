package com.natifedanilharitonov.hardskillsproject.presentation.mainFirst.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.natifedanilharitonov.hardskillsproject.R
import com.natifedanilharitonov.hardskillsproject.presentation.baseComponentsKit.ButtonColumn
import com.natifedanilharitonov.hardskillsproject.presentation.main.components.MainButton
import com.natifedanilharitonov.hardskillsproject.presentation.main.components.MainText
import com.natifedanilharitonov.hardskillsproject.presentation.main.components.PageTitle
import com.natifedanilharitonov.hardskillsproject.ui.theme.HardSkillsProjectTheme

@Composable
fun MainViewContainer(
    title: String,
    text: String?,
    navigate: () -> Unit,
    buttonText: String,
    popBack: () -> Unit,
) {
    PageTitle(text = title)

    MainText(text = text)

    ButtonColumn(
        popBackText = stringResource(id = R.string.back),
        popBack = popBack,
        navigateNext = navigate,
        navigateNextText = buttonText,
    )
    MainButton(
        text = buttonText,
        onClick = navigate,
    )
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewMainFirstView() {
    HardSkillsProjectTheme {
        MainViewContainer(
            title = "Title",
            text = "text text text text text text text text ",
            navigate = { },
            buttonText = "navigate",
            popBack = {},
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewMainFirstErrorView() {
    HardSkillsProjectTheme {
        MainViewContainer(
            title = "Title",
            text = null,
            navigate = { },
            buttonText = "navigate",
            popBack = {},
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewMainFirstPendingView() {
    HardSkillsProjectTheme {
        MainViewContainer(
            title = "Title",
            text = "",
            navigate = { },
            buttonText = "navigate",
            popBack = {},
        )
    }
}
