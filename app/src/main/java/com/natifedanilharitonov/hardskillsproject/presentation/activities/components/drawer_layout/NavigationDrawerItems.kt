package com.natifedanilharitonov.hardskillsproject.presentation.activities.components.drawer_layout

import android.content.Context
import com.natifedanilharitonov.hardskillsproject.R
import com.natifedanilharitonov.hardskillsproject.presentation.base.screens.Screen
import kotlinx.collections.immutable.persistentListOf

class NavigationDrawerItems(context: Context) {
    val items = persistentListOf(
        NavigationDrawerItem(
            route = Screen.StatisticsScreen.route,
            title = context.getString(R.string.statistics),
            icon = R.drawable.stats
        ),
        NavigationDrawerItem(
            route = Screen.RandomAnimeImage.route,
            title = context.getString(R.string.random_anime_image),
            icon = R.drawable.onboarding
        ),
        NavigationDrawerItem(
            route = Screen.UsersScreen.route,
            title = context.getString(R.string.users),
            icon = R.drawable.users
        )
    )
}