package com.natifedanilharitonov.hardskillsproject.presentation.user_list.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.natifedanilharitonov.hardskillsproject.presentation.user_list.model.UiUser
import com.natifedanilharitonov.hardskillsproject.presentation.user_list.model.UserPaginationUiModel
import kotlinx.collections.immutable.PersistentList


@Composable
fun UserListColumn(
    modifier: Modifier = Modifier,
    userList: PersistentList<UiUser>,
    pagingState: UserPaginationUiModel,
    addUsers: () -> Unit,
    canPaging: Boolean
) {

    LazyColumn(modifier = modifier.fillMaxSize()) {
        itemsIndexed(userList, key = { _, item -> item.email }) { index, item ->
            UserCard(
                image = item.picture.medium,
                name = item.name
            )
            if (index >= userList.size - 4 && canPaging){
                addUsers()
            }
        }

        item {
            when (pagingState) {
                is UserPaginationUiModel.Paging -> {
                    PagingPending()
                }

                is UserPaginationUiModel.Idle -> {}
            }
        }
    }
}