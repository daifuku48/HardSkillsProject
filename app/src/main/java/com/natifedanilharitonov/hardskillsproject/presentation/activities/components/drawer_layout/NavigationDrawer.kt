package com.natifedanilharitonov.hardskillsproject.presentation.activities.components.drawer_layout

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun NavigationDrawer(
    menuItems: List<NavigationDrawerItem>,
    navigate: (String) -> Unit
) {
    ModalDrawerSheet {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(menuItems) { item ->
                MenuItem(item = item, onItemClick = { route -> navigate(route) })
            }
        }
    }
}