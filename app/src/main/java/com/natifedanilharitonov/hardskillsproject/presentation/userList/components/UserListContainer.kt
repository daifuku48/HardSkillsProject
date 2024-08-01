package com.natifedanilharitonov.hardskillsproject.presentation.userList.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.natifedanilharitonov.hardskillsproject.presentation.baseComponentsKit.ButtonColumn
import com.natifedanilharitonov.hardskillsproject.presentation.baseComponentsKit.previewUser
import com.natifedanilharitonov.hardskillsproject.presentation.userList.model.UiUser
import com.natifedanilharitonov.hardskillsproject.ui.theme.HardSkillsProjectTheme
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf

@Composable
fun UserListContainer(
    userList: PersistentList<UiUser>?,
    addUsers: () -> Unit,
    pagingValue: Boolean,
    backToMain: () -> Unit,
    backToMainText: String,
    popBack: () -> Unit,
    popBackText: String,
) {
    when (userList) {
        null -> {
            ErrorListScreen()
        }

        persistentListOf<UiUser>() -> {
            PendingListScreen()
        }

        else -> {
            UserListColumn(
                userList = userList,
                addUsers = addUsers,
                canPaging = pagingValue,
            )
            ButtonColumn(
                popBackText = popBackText,
                popBack = popBack,
                navigateNext = backToMain,
                navigateNextText = backToMainText,
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewUserListContainer() {
    HardSkillsProjectTheme {
        UserListContainer(
            userList =

            persistentListOf(
                previewUser(),
                previewUser(),
                previewUser(),
                previewUser(),
                previewUser(),
                previewUser(),
            ),
            addUsers = {},
            pagingValue = false,
            backToMain = {},
            popBack = {},
            popBackText = "Back",
            backToMainText = "Back to Main",
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewUserListErrorContainer() {
    HardSkillsProjectTheme {
        UserListContainer(
            userList = null,
            addUsers = {},
            pagingValue = false,
            backToMain = {},
            popBack = {},
            popBackText = "Back",
            backToMainText = "Back to Main",
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewUserListPendingContainer() {
    HardSkillsProjectTheme {
        UserListContainer(
            userList = persistentListOf(),
            addUsers = {},
            pagingValue = false,
            backToMain = {},
            popBack = {},
            popBackText = "Back",
            backToMainText = "Back to Main",
        )
    }
}
