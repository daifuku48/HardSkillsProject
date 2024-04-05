package com.natifedanilharitonov.hardskillsproject.presentation.activities.components.drawerLayout

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp

@Composable
fun MenuItem(
    item: NavigationDrawerItem,
    onItemClick: (route: String) -> Unit,
) {
    Row(
        modifier =
            Modifier
                .fillMaxWidth()
                .clickable {
                    onItemClick(item.route)
                }
                .padding(16.dp),
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(id = item.icon),
            contentDescription = item.title,
        )

        Text(text = item.title, modifier = Modifier.weight(1f))
    }
}
