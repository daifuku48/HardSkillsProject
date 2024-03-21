package com.natifedanilharitonov.hardskillsproject.presentation.activities.components.drawer_layout

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import kotlinx.collections.immutable.PersistentList

@Composable
fun NavigationDrawer(
    menuItems: PersistentList<NavigationDrawerItem>,
    currentRoute: String?,
    navigate: (String) -> Unit,
    closeDrawer: () -> Unit
) {
    ModalDrawerSheet {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(menuItems) { item ->
                MenuItem(
                    item = item,
                    onItemClick = { route ->
                        if (route != currentRoute) {
                            navigate(route)
                        } else {
                            closeDrawer()
                        }
                    }
                )
            }
        }
    }
}