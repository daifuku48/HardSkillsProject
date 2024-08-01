package com.natifedanilharitonov.hardskillsproject.presentation.activities.components.drawerLayout

import android.content.Context
import com.natifedanilharitonov.hardskillsproject.R
import com.natifedanilharitonov.hardskillsproject.base.navigation.Screen
import kotlinx.collections.immutable.persistentListOf

class NavigationDrawerItems(
    context: Context,
) {
    val items =
        persistentListOf(
            NavigationDrawerItem(
                route = Screen.StatisticsScreen.route,
                title = context.getString(R.string.statistics),
                icon = R.drawable.stats,
            ),
            NavigationDrawerItem(
                route = Screen.RandomAnimeImageScreen.route,
                title = context.getString(R.string.random_anime_image),
                icon = R.drawable.onboarding,
            ),
            NavigationDrawerItem(
                route = Screen.RandomUserFirstScreen.route,
                title = context.getString(R.string.users),
                icon = R.drawable.users,
            ),
        )
}
