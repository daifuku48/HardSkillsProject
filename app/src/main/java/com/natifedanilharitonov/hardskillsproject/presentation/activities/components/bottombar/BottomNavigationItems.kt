package com.natifedanilharitonov.hardskillsproject.presentation.activities.components.bottombar

import android.content.Context
import com.natifedanilharitonov.hardskillsproject.R
import com.natifedanilharitonov.hardskillsproject.base.navigation.Screen
import kotlinx.collections.immutable.persistentListOf

class BottomNavigationItems(
    context: Context,
) {
    val bottomItems =
        persistentListOf(
            BottomNavigationItem(
                label = context.getString(R.string.home),
                icon = R.drawable.home,
                route = Screen.MainScreen.route,
            ),
            BottomNavigationItem(
                label = context.getString(R.string.info),
                icon = R.drawable.info,
                route = Screen.InfoScreen.route,
            ),
            BottomNavigationItem(
                label = context.getString(R.string.settings),
                icon = R.drawable.settings,
                route = Screen.SettingsScreen.route,
            ),
        )
}
