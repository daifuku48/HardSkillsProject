package com.natifedanilharitonov.hardskillsproject.presentation.activities.bottombar

import android.content.Context
import com.natifedanilharitonov.hardskillsproject.R
import com.natifedanilharitonov.hardskillsproject.presentation.base.screens.Screen
import kotlinx.collections.immutable.persistentListOf

data class BottomNavigationItems(private val context: Context) {
    val bottomItems = persistentListOf(
        BottomNavigationItem(
            label = context.getString(R.string.home),
            icon = R.drawable.home,
            route = Screen.MainScreen.route
        ),
        BottomNavigationItem(
            label = context.getString(R.string.info),
            icon = R.drawable.info,
            route = Screen.InfoScreen.route
        ),
        BottomNavigationItem(
            label = context.getString(R.string.settings),
            icon = R.drawable.settings,
            route = Screen.SettingsScreen.route
        )
    )
}