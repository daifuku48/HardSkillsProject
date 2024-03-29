package com.natifedanilharitonov.hardskillsproject.presentation.user_list.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.natifedanilharitonov.hardskillsproject.presentation.user_list.model.UiUser
import kotlinx.collections.immutable.PersistentList


@Composable
fun UserListColumn(
    modifier: Modifier = Modifier,
    userList: PersistentList<UiUser>
) {
    LazyColumn(modifier = modifier.fillMaxSize()) {
        items(userList.size) { index ->
            UserCard(
                image = userList[index].picture.medium,
                name = userList[index].name
            )
        }
    }
}