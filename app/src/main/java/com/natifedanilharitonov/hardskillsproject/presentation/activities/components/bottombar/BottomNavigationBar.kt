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
import com.natifedanilharitonov.hardskillsproject.R

@Composable
fun BottomNavigationBar(
    bottomState: Boolean,
    navigationSelectedItem: Int,
    navigate: (String, Int) -> Unit
) {
    val context = LocalContext.current
    if (bottomState){
        NavigationBar(
            containerColor = colorResource(id = R.color.light_blue)
        ) {
            BottomNavigationItems(context).bottomItems.forEachIndexed() { index, item ->
                NavigationBarItem(
                    selected = index == navigationSelectedItem,
                    label = {
                        Text(item.label)
                    },
                    icon = {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = item.icon),
                            contentDescription = item.label
                        )
                    },
                    onClick = {
                        navigate(item.route, index)
                    }
                )
            }
        }
    }
}