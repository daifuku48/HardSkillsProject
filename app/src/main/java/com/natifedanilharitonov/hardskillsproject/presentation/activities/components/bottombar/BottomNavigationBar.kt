package com.natifedanilharitonov.hardskillsproject.presentation.activities.components.bottombar

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.vectorResource
import androidx.navigation.NavBackStackEntry
import com.natifedanilharitonov.hardskillsproject.R

@Suppress("ktlint:standard:function-naming")
@Composable
fun BottomNavigationBar(
    bottomState: Boolean,
    navigate: (String, Int) -> Unit,
    backStackEntry: NavBackStackEntry?,
) {
    val context = LocalContext.current
    if (bottomState) {
        NavigationBar(
            containerColor = colorResource(id = R.color.light_blue),
        ) {
            BottomNavigationItems(context).bottomItems.forEachIndexed { index, item ->
                NavigationBarItem(
                    selected = item.route == backStackEntry?.destination?.route,
                    label = {
                        Text(item.label)
                    },
                    icon = {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = item.icon),
                            contentDescription = item.label,
                        )
                    },
                    onClick = {
                        if (backStackEntry?.destination?.route != item.route) {
                            navigate(item.route, index)
                        }
                    },
                )
            }
        }
    }
}
