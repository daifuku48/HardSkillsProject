package com.natifedanilharitonov.hardskillsproject.presentation.userList.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import com.natifedanilharitonov.hardskillsproject.presentation.userList.model.UiUser
import com.natifedanilharitonov.hardskillsproject.presentation.userList.model.UserPaginationUiModel
import com.natifedanilharitonov.hardskillsproject.utils.TestTags.PAGING_PENDING_TAG
import com.natifedanilharitonov.hardskillsproject.utils.TestTags.USER_LIST_ITEM_TAG
import kotlinx.collections.immutable.PersistentList

@Composable
fun UserListColumn(
    modifier: Modifier = Modifier,
    userList: PersistentList<UiUser>,
    pagingState: UserPaginationUiModel,
    addUsers: () -> Unit,
    canPaging: Boolean,
) {
    LazyColumn(modifier = modifier.fillMaxSize()) {
        itemsIndexed(userList, key = { _, item -> item.email }) { index, item ->
            UserCard(
                modifier = Modifier.testTag(USER_LIST_ITEM_TAG),
                image = item.picture.medium,
                name = item.name,
            )
            if (index >= userList.size - 4 && canPaging) {
                addUsers()
            }
        }

        item {
            when (pagingState) {
                is UserPaginationUiModel.Paging -> {
                    PagingPending(modifier = Modifier.testTag(PAGING_PENDING_TAG))
                }

                is UserPaginationUiModel.Idle -> {}
            }
        }
    }
}
