package com.natifedanilharitonov.hardskillsproject.presentation.userList.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.natifedanilharitonov.hardskillsproject.presentation.baseComponents.ButtonColumn
import com.natifedanilharitonov.hardskillsproject.presentation.baseComponents.previewUser
import com.natifedanilharitonov.hardskillsproject.presentation.userList.model.UserListUiModel
import com.natifedanilharitonov.hardskillsproject.presentation.userList.model.UserPaginationUiModel
import com.natifedanilharitonov.hardskillsproject.ui.theme.HardSkillsProjectTheme
import kotlinx.collections.immutable.persistentListOf

@Composable
fun UserListContainer(
    userList: UserListUiModel,
    addUsers: () -> Unit,
    pagingValue: Boolean,
    pagingState: UserPaginationUiModel,
    backToMain: () -> Unit,
    backToMainText: String,
    popBack: () -> Unit,
    popBackText: String,
) {
    when (userList) {
        UserListUiModel.ErrorList -> {
            ErrorListScreen()
        }

        is UserListUiModel.List -> {
            UserListColumn(
                userList = userList.userList,
                addUsers = addUsers,
                canPaging = pagingValue,
                pagingState = pagingState,
            )
            ButtonColumn(
                popBackText = popBackText,
                popBack = popBack,
                navigateNext = backToMain,
                navigateNextText = backToMainText,
            )
        }

        UserListUiModel.Pending -> {
            PendingListScreen()
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewUserListContainer() {
    HardSkillsProjectTheme {
        UserListContainer(
            userList =
                UserListUiModel.List(
                    persistentListOf(
                        previewUser(),
                        previewUser(),
                        previewUser(),
                        previewUser(),
                        previewUser(),
                        previewUser(),
                    ),
                ),
            addUsers = {},
            pagingValue = false,
            pagingState = UserPaginationUiModel.Idle,
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
            userList = UserListUiModel.ErrorList,
            addUsers = {},
            pagingValue = false,
            pagingState = UserPaginationUiModel.Idle,
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
            userList = UserListUiModel.Pending,
            addUsers = {},
            pagingValue = false,
            pagingState = UserPaginationUiModel.Idle,
            backToMain = {},
            popBack = {},
            popBackText = "Back",
            backToMainText = "Back to Main",
        )
    }
}
