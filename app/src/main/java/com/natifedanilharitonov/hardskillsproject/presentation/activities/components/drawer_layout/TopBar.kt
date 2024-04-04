package com.natifedanilharitonov.hardskillsproject.presentation.activities.components.drawer_layout

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import com.natifedanilharitonov.hardskillsproject.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    drawerState: Boolean,
    onNavigationDrawerClick: () -> Unit
) {
    if (drawerState) {
        TopAppBar(
            modifier = modifier,
            title = {
                Text(text = stringResource(id = R.string.app_name))
            },
            navigationIcon = {
                IconButton(
                    content = {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.menu),
                            contentDescription = "Menu"
                        )
                    },
                    onClick = onNavigationDrawerClick
                )
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = colorResource(id = R.color.black_top_bar),
                titleContentColor = colorResource(id = R.color.white)
            )
        )
    }
}