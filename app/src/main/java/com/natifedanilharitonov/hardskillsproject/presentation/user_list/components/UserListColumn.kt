package com.natifedanilharitonov.hardskillsproject.presentation.user_list.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.natifedanilharitonov.hardskillsproject.domain.model.DomainUser
import kotlinx.collections.immutable.PersistentList


@Composable
fun UserListColumn(modifier: Modifier = Modifier, userList: PersistentList<DomainUser>) {
    LazyColumn(modifier = modifier.fillMaxSize()) {
        items(userList.size) { index ->
            UserCard(
                image = userList[index].picture.medium,
                name = userList[index].name
            )
        }
    }
}